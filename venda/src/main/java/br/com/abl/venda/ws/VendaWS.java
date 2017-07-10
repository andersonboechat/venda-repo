package br.com.abl.venda.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.abl.venda.CapturaTask;
import br.com.abl.venda.persistence.ItemVenda;
import br.com.abl.venda.persistence.Processamento;
import br.com.abl.venda.persistence.Venda;
import br.com.abl.venda.service.ProcessamentoService;

@Path("/")
public class VendaWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)	
	public void recebeVenda(Venda venda) {
		List<Processamento> processamentos = new ArrayList<Processamento>();

		for (ItemVenda item : venda.getItens()) {
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

		CapturaTask.pService.save(processamentos);
	}
}
