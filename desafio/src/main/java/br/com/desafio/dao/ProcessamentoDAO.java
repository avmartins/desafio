package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.entity.*;

public interface ProcessamentoDAO {
	public void addProcessamento(Processamento processamento);
	public void updateProcessamento(Processamento processamento);
    public List<Processamento> getProcessamentos(String data, String loja, String status);
    public void deleteProcessamento(Integer vendaId);
    public Integer maxId();
}
