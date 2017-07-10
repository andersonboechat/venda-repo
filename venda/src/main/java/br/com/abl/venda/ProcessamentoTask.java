package br.com.abl.venda;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;

import br.com.abl.venda.persistence.Processamento;
import br.com.abl.venda.service.ProcessamentoService;

public class ProcessamentoTask extends TimerTask {

	private static final Logger LOGGER = Logger.getLogger(Processamento.class);

	public static String FILENAME = DateFormatUtils.format(new Date(), "'processamento_'yyyy-MM-dd_HHmmss'.txt'");
	
	private static final File DIRECTORY = new File("processados"); //FileUtils.getUserDirectory();

	private static final String ZERO = "0";

	private static ProcessamentoService pService = (ProcessamentoService) SpringApplicationContext.getBean("processamentoServiceImpl");

	static {
		try {
			FileUtils.forceMkdir(DIRECTORY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		processa();
	}

	public static synchronized void processa() {
		try {
			List<Processamento> processamentos = pService.getProcessamentosPendentes();
			
			for (Processamento processamento : processamentos) {
				LOGGER.info("Processando venda " + processamento.getIdVenda());
				
				File file = FileUtils.getFile(DIRECTORY,FILENAME);

				if (!file.exists()) {
					file.createNewFile();
				}

				if (CollectionUtils.size(FileUtils.readLines(file, "UTF-8")) >= 10) {
					FILENAME = DateFormatUtils.format(new Date(), "'processamento_'yyyy-MM-dd_HHmmss'.txt'");
					file = FileUtils.getFile(DIRECTORY, FILENAME);
					file.createNewFile();
				}

				StringBuffer sb = new StringBuffer();

				sb.append(StringUtils.leftPad(String.valueOf(processamento.getIdVenda()), 11, ZERO));
				sb.append(StringUtils.leftPad(DateFormatUtils.format(processamento.getData(), "ddMMyyyy"), 8, ZERO));
				sb.append(StringUtils.leftPad(String.valueOf(processamento.getLoja()), 4, ZERO));
				sb.append(StringUtils.leftPad(String.valueOf(processamento.getPdv()), 3, ZERO));
				sb.append(StringUtils.leftPad(processamento.getProduto(), 11, ZERO));
				sb.append(StringUtils.leftPad(String.valueOf(processamento.getPrecoUnitario()).replaceAll("[^0-9]+", ""), 5, ZERO));
				sb.append(StringUtils.leftPad(String.valueOf(processamento.getDesconto()).replaceAll("[^0-9]+", ""), 5, ZERO));

				double valorTotal = processamento.getPrecoUnitario() - processamento.getDesconto();

				sb.append(StringUtils.leftPad(String.format("%.2f", valorTotal).replaceAll("[^0-9]+", ""), 5, ZERO));
				sb.append(IOUtils.LINE_SEPARATOR);

				FileUtils.writeStringToFile(file, sb.toString(), "UTF-8", true);

				processamento.setNomeArquivo(FILENAME);
				processamento.setStatus(ProcessamentoService.OK_STATUS);

				pService.save(processamento);

				LOGGER.info("Venda " + processamento.getIdVenda() + " capturada com sucesso. Salva no arquivo " + FILENAME);
			}
		} catch (Exception e) {
			LOGGER.info("Falha ao processar vendas " + e.getMessage());
		}
	}

}
