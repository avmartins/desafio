package br.com.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.dao.ProcessamentoDAO;
import br.com.desafio.entity.Processamento;

@Service
public class ProcessamentoManagerImpl implements ProcessamentoManager {
	
	@Autowired(required=true)
    private ProcessamentoDAO processamentoDAO;

	@Transactional
	public void addProcessamento(Processamento processamento) {
		processamentoDAO.addProcessamento(processamento);
	}
	
	@Transactional
	public void updateProcessamento(Processamento processamento) {
		processamentoDAO.updateProcessamento(processamento);
	}

	@Transactional
	public List<Processamento> getProcessamentos(String data, String loja, String status) {
		return processamentoDAO.getProcessamentos(data, loja, status);
	}

	@Transactional
	public void deleteProcessamento(Integer processamentoId) {
		processamentoDAO.deleteProcessamento(processamentoId);
	}
	
	@Transactional
	public Integer maxId() {
		return processamentoDAO.maxId();
	}

	public void setProcessamentoDAO(ProcessamentoDAO processamentoDAO) {
		this.processamentoDAO = processamentoDAO;
	}
}
