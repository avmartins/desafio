package br.com.desafio.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.entity.Processamento;

@Repository	
public class ProcessamentoDaoImpl  implements ProcessamentoDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addProcessamento(Processamento processamento) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(processamento);
	}

	@SuppressWarnings("unchecked")
	public List<Processamento> getProcessamentos(String data, String loja, String status) {
		return this.sessionFactory.getCurrentSession().createQuery("from Processamento").list();
	}

	public void deleteProcessamento(Integer processamentoId) {
		Processamento processamento = (Processamento) sessionFactory.getCurrentSession().load(
				Processamento.class, processamentoId);
        if (null != processamento) {
        	this.sessionFactory.getCurrentSession().delete(processamento);
        }
	}
	
	public void updateProcessamento(Processamento processamento) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(processamento);
	}
	
	@SuppressWarnings("unchecked")
	public Integer maxId() {
		return (Integer)this.sessionFactory.getCurrentSession().createQuery("select max(p.id) from Processamento p").list().get(0);
	}
	
	

}