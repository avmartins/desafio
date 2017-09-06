package br.com.desafio.service;

import java.util.List;

import br.com.desafio.dao.ProcessamentoDAO;
import br.com.desafio.entity.Processamento;

public interface ProcessamentoManager {
    	public List<Processamento> getProcessamentos(String data, String loja, String status);
    	public void addProcessamento(Processamento processamento);
    	public void updateProcessamento(Processamento processamento);
    	public void deleteProcessamento(Integer processamentoId);
    	public void setProcessamentoDAO(ProcessamentoDAO processamentoDAO);
    	public Integer maxId();
}
