package br.com.abl.venda.service;

import br.com.abl.venda.persistence.Venda;

public interface VendaService {
	
	final String OK_STATUS = "OK";

	final String NAO_PROCESSADO_STATUS = "NÃO PROCESSADO";

	Venda getVenda();

	void save(Venda venda);

}
