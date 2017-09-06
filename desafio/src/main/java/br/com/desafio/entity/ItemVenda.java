package br.com.desafio.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="tb_item_venda")
public class ItemVenda implements Serializable {
	
	@Id
	@Column(name="id_item_venda")
	private Integer itemVendaId;
	
	@Column(name="id_venda")
	private Integer vendaId;
	
	@Column(name="produto")
	private String produto;
	
	@Column(name="preco_unitario")
	private BigDecimal precoUnitario;
	
	@Column(name="desconto")
	private BigDecimal valorDesconto;
	
    public Integer getVendaId() {
		return vendaId;
	}

	public void setVendaId(Integer vendaId) {
		this.vendaId = vendaId;
	}

	public Integer getItemVendaId() {
		return itemVendaId;
	}

	public void setItemVendaId(Integer itemVendaId) {
		this.itemVendaId = itemVendaId;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {


        BigDecimal precoUnitarioNew = precoUnitario;
        if (precoUnitarioNew == null) {
            precoUnitarioNew = BigDecimal.ZERO;
        }
        BigDecimal valorDescontoNew = valorDesconto;

        if (valorDescontoNew == null)
            valorDescontoNew = BigDecimal.ZERO;

        return precoUnitarioNew.subtract(valorDescontoNew);
    }

}
