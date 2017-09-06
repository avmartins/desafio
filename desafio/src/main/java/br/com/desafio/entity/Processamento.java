package br.com.desafio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity		
@Table(name="tb_processamento")
public class Processamento implements Serializable	 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6505569930381596517L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_processamento")
	private Integer id;
	@Column(name="data")
	private Date data;
	@Column(name="loja")
	private Integer loja;
	@Column(name="pdv")
	private Integer pdv;
	@Column(name="nome_arquivo")
	private String nomeArquivo;
	@Column(name="status")
	private String status;
	
	public Processamento() {
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

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
