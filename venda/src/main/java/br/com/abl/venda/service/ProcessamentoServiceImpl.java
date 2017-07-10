package br.com.abl.venda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abl.venda.persistence.Processamento;
import br.com.abl.venda.persistence.repository.ProcessamentoRepository;

@Service
public class ProcessamentoServiceImpl implements ProcessamentoService {

	@Autowired
	ProcessamentoRepository repository;

	@Override
	public List<Processamento> getProcessamentosPendentes() {
		return repository.findByStatus(ProcessamentoService.PENDENTE_STATUS);
	}

	@Override
	public void save(Processamento processamento) {
		repository.save(processamento);
	}

	@Override
	public void save(List<Processamento> processamentos) {
		repository.save(processamentos);
	}

	@Override
	public List<Processamento> getProcessamentos() {
		return (List<Processamento>) repository.findAll();
	}
}
