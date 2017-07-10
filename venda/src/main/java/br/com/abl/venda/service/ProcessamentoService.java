package br.com.abl.venda.service;

import java.util.List;

import br.com.abl.venda.persistence.Processamento;

public interface ProcessamentoService {

	final String PENDENTE_STATUS = "PENDENTE";
	
	final String OK_STATUS = "OK";
	
	List<Processamento> getProcessamentos();
	
	List<Processamento> getProcessamentosPendentes();

	void save(Processamento processamento);

	void save(List<Processamento> processamentos);

}
