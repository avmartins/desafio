package br.com.desafio.dto;

public class ItemDTO {
	
	private String produto;
	private String preco_unitario;
	private String desconto;
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(String preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

}