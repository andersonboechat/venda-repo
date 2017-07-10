package br.com.abl.venda;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import br.com.abl.venda.SpringApplicationContext;
import br.com.abl.venda.persistence.ItemVenda;
import br.com.abl.venda.persistence.Processamento;
import br.com.abl.venda.persistence.Venda;
import br.com.abl.venda.service.ProcessamentoService;
import br.com.abl.venda.service.VendaService;

public class CapturaTask extends TimerTask {
	
	private static final Logger LOGGER = Logger.getLogger(CapturaTask.class);

	private static VendaService vService = (VendaService) SpringApplicationContext.getBean("vendaServiceImpl");

	public static ProcessamentoService pService = (ProcessamentoService) SpringApplicationContext.getBean("processamentoServiceImpl");
	
	@Override
	public void run() {
		captura();
	}

	public static synchronized void captura() {
		Venda venda = null;

		try {
			venda = vService.getVenda();

			if (venda != null) {
				LOGGER.info("Capturando venda " + venda);
				
				List<Processamento> processamentos = new ArrayList<Processamento>();

				for (ItemVenda item : venda.getItens()) {
					LOGGER.info("Processando item " + item);

					Processamento processamento = new Processamento();
					processamento.setIdVenda(venda.getIdVenda());
					processamento.setData(venda.getData());
					processamento.setLoja(venda.getLoja());
					processamento.setPdv(venda.getPdv());
					processamento.setProduto(item.getProduto());
					processamento.setPrecoUnitario(item.getPrecoUnitario());
					processamento.setDesconto(item.getDesconto());
					processamento.setStatus(ProcessamentoService.PENDENTE_STATUS);

					processamentos.add(processamento);
				}

				pService.save(processamentos);

				venda.setStatus(VendaService.OK_STATUS);
				vService.save(venda);

				LOGGER.info("Venda " + venda.getIdVenda() + " capturada com sucesso");
			}
		} catch (Exception e) {
			LOGGER.info("Falha ao capturar venda " + venda.getIdVenda()  +": " + e.getMessage());
		}
	}

}