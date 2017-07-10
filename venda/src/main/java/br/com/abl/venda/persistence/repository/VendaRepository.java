package br.com.abl.venda.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.abl.venda.persistence.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {

	public List<Venda> findByStatus(String status);

}
