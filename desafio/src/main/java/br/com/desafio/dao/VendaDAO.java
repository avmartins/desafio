package br.com.desafio.dao;

import java.sql.Date;
import java.util.List;

import br.com.desafio.entity.*;

public interface VendaDAO {
	public void addVenda(Venda venda);
	public void updateVenda(Venda venda);
	public void deleteVenda(Integer vendaId);
	public Venda getVenda(Integer vendaId);
    public List<Venda> getAllVendas();
    public ItemVenda getItemVenda(Integer vendaId, Integer itemVendaId);
    public List<ItemVenda> getAllItemVendas(Date datai, Date dataf);
    public List<ItemVenda> getAllItemVendas(String status);
    public List<ItemVenda> getAllItemVendas(Integer idVenda);
    public Integer maxId();
    public Integer maxIdItem(Integer vendaId);    
    public void addItemVenda(ItemVenda item);
	public void deleteItemVenda(Integer itemVendaId);	
	public void updateItemVenda(ItemVenda itemVenda);
}
