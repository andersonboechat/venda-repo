package br.com.abl.venda.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_item_venda database table.
 * 
 */
@Entity
@Table(name="tb_item_venda")
public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemVendaPK id;

	@ManyToOne
	@JoinColumn(name="id_venda", insertable=false, updatable=false)
	private Venda venda;

	private double desconto;

	@Column(name="preco_unitario")
	private double precoUnitario;

	private String produto;

	public ItemVenda() {
	}

	public ItemVendaPK getId() {
		return this.id;
	}

	public void setId(ItemVendaPK id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getProduto() {
		return this.produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

}