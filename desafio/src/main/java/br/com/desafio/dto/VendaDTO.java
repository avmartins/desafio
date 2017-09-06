package br.com.desafio.dto;

import java.util.Date;

public class VendaDTO {
	
	private Integer id_venda;
	private Date data;
	private Integer loja;
	private Integer pdv;
	
	private ItemDTO[] itens;

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public Integer getPdv() {
		return pdv;
	}

	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}

	public ItemDTO[] getItens() {
		return itens;
	}

	public void setItens(ItemDTO[] itens) {
		this.itens = itens;
	}

}
