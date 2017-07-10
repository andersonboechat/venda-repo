package br.com.abl.venda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.abl.venda.persistence.Venda;
import br.com.abl.venda.persistence.repository.VendaRepository;

@Component
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository repository;

	@Override
	public Venda getVenda() {
		return repository.findByStatus(VendaService.NAO_PROCESSADO_STATUS).get(0);
	}

	@Override
	public void save(Venda venda) {
		repository.save(venda);
	}

}
