package br.com.abl.venda.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_venda database table.
 * 
 */
@Entity
@Table(name="tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_venda")
	private long idVenda;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int loja;

	private int pdv;

	private String status;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="venda", fetch=FetchType.EAGER)
	private List<ItemVenda> itens;

	public Venda() {
	}

	public long getIdVenda() {
		return this.idVenda;
	}

	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getLoja() {
		return this.loja;
	}

	public void setLoja(int loja) {
		this.loja = loja;
	}

	public int getPdv() {
		return this.pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

}