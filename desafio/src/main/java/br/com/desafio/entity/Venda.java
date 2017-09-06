package br.com.desafio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venda")
	private Integer id;
	@Column(name="data")
	private Date data;
	@Column(name="loja")
	private Integer loja;
	@Column(name="pdv")
	private Integer pdv;
	@Column(name="status")
	private String status;
	
	public Venda() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", loja=" + loja + ", pdv=" + pdv + ", status=" + status + "]";
	}
}