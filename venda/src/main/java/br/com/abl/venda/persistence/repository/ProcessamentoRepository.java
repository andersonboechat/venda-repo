package br.com.abl.venda.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.abl.venda.persistence.Processamento;

@Repository
public interface ProcessamentoRepository extends CrudRepository<Processamento, Long> {

	List<Processamento> findByStatus(String status);

}
