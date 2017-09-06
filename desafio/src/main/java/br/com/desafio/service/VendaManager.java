package br.com.desafio.service;

import java.sql.Date;
import java.util.List;

import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Venda;

public interface VendaManager {
    	public void addVenda(Venda venda);
    	public void updateVenda(Venda venda);
    	public void deleteVenda(Integer vendaId);
    	public Venda getVenda(Integer vendaId);
        public List<Venda> getAllVendas();
        public Integer maxId();
        
        public void addItemVenda(ItemVenda item);
    	public void deleteItemVenda(Integer itemVendaId);	
    	public void updateItemVenda(ItemVenda itemVenda);
    	public ItemVenda getItemVenda(Integer vendaId, Integer itemVendaId);
        public List<ItemVenda> getAllItemVendas(Date datai, Date dataf);
        public List<ItemVenda> getAllItemVendas(Integer idVenda);
        public List<ItemVenda> getAllItemVendas(String status);
        public Integer maxIdItem(Integer vendaId);
}
