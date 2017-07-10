package br.com.abl.venda.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_item_venda database table.
 * 
 */
@Embeddable
public class ItemVendaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_venda")
	private long idVenda;

	@Column(name="id_item_venda")
	private long idItemVenda;

	public ItemVendaPK() {
	}
	public long getIdVenda() {
		return this.idVenda;
	}
	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}
	public long getIdItemVenda() {
		return this.idItemVenda;
	}
	public void setIdItemVenda(long idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemVendaPK)) {
			return false;
		}
		ItemVendaPK castOther = (ItemVendaPK)other;
		return 
			(this.idVenda == castOther.idVenda)
			&& this.idItemVenda == castOther.idItemVenda;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idVenda ^ (this.idVenda >>> 32)));
		
		return hash;
	}
}