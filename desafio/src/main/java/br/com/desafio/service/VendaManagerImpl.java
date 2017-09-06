package br.com.desafio.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.dao.VendaDAO;
import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Venda;

@Service
public class VendaManagerImpl implements VendaManager {
	
	@Autowired(required=true)
    private VendaDAO vendaDAO;

	@Transactional
	public void addVenda(Venda venda) {
		vendaDAO.addVenda(venda);
	}
	
	@Transactional
	public void updateVenda(Venda venda) {
		vendaDAO.updateVenda(venda);
	}

	@Transactional
	public List<Venda> getAllVendas() {
		return vendaDAO.getAllVendas();
	}
	
	@Transactional
	public Venda getVenda(Integer vendaId) {
		Venda venda = vendaDAO.getVenda(vendaId);
		return venda;
	}
	
	@Transactional
	public void deleteVenda(Integer vendaId) {
		vendaDAO.deleteVenda(vendaId);
	}
	
	@Transactional
    public ItemVenda getItemVenda(Integer vendaId, Integer itemVendaId){
		return vendaDAO.getItemVenda(vendaId, itemVendaId);
	}
    
	@Transactional
	public List<ItemVenda> getAllItemVendas(Date datai,Date dataf){
		return vendaDAO.getAllItemVendas(datai,dataf);
	}
	
	@Transactional
	public List<ItemVenda> getAllItemVendas(String status){
		return vendaDAO.getAllItemVendas(status);
	}
	
	@Transactional
	public List<ItemVenda> getAllItemVendas(Integer idVenda){
		return vendaDAO.getAllItemVendas(idVenda);
	}
	
	@Transactional
	public void addItemVenda(ItemVenda item) {
		vendaDAO.addItemVenda(item);
	}
	
	@Transactional
  	public void deleteItemVenda(Integer itemVendaId){
		vendaDAO.deleteItemVenda(itemVendaId);
	}
  	
	@Transactional
	public void updateItemVenda(ItemVenda itemVenda){
		vendaDAO.updateItemVenda(itemVenda);
	}
	
	@Transactional
	public Integer maxId() {
		return vendaDAO.maxId();
	}
    
	@Transactional
	public Integer maxIdItem(Integer vendaId) {
		return vendaDAO.maxIdItem(vendaId);
	}
	
	public void setVendaDAO(VendaDAO vendaDAO) {
		this.vendaDAO = vendaDAO;
	}
	
}
