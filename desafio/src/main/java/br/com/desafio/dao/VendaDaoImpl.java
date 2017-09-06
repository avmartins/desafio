package br.com.desafio.dao;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Venda;

@Repository	
public class VendaDaoImpl implements VendaDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addVenda(Venda venda) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(venda);
	}

	public void deleteVenda(Integer vendaId) {
		Venda venda = (Venda) sessionFactory.getCurrentSession().load(
				Venda.class, vendaId);
        if (null != venda) {
        	this.sessionFactory.getCurrentSession().delete(venda);
        }
	}
	
	public void updateVenda(Venda venda) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(venda);
	}
	
	@SuppressWarnings("unchecked")
	public Venda getVenda(Integer vendaId) {
		Venda venda = (Venda) sessionFactory.getCurrentSession().load(Venda.class, vendaId);
		System.out.println(venda.toString());
		return venda;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> getAllVendas() {
		return this.sessionFactory.getCurrentSession().createQuery("from Venda").list();
	}	
	
	public void addItemVenda(ItemVenda item) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(item);
	}

	public void deleteItemVenda(Integer itemVendaId) {
		ItemVenda itemVenda = (ItemVenda) sessionFactory.getCurrentSession().load(
				ItemVenda.class, itemVendaId);
        if (null != itemVenda) {
        	this.sessionFactory.getCurrentSession().delete(itemVenda);
        }
	}
	
	public void updateItemVenda(ItemVenda itemVenda) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(itemVenda);
	}
	
	@SuppressWarnings("unchecked")
	public ItemVenda getItemVenda(Integer vendaId, Integer itemVendaId) {
		Query query = sessionFactory.
				getCurrentSession().createSQLQuery("SELECT * tb_item_Venda i WHERE v.id_venda = " + vendaId + " and id_item_venda = " + itemVendaId).addEntity(ItemVenda.class);
		
		return (ItemVenda)query.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> getAllItemVendas(Date datai, Date dataf) {
		
		List<ItemVenda> itens = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT v.id_venda, v.data, v.loja, v.pdv, v.status, i.id_item_venda, i.produto, i.preco_unitario, i.desconto ");
		sql.append("FROM tb_venda v, tb_item_Venda i ");
		sql.append("WHERE v.id_venda = i.id_venda and v.status = 'OK' and ( date(v.data) >= :dataI and date(v.data) <= :dataF ) ");
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).addEntity(ItemVenda.class);
		
		query.setDate("dataI", datai);
		query.setDate("dataF", dataf);

		itens = query.list();
		
		return itens;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> getAllItemVendas(String status) {
		
		List<ItemVenda> itens = null;
		
		StringBuffer sql = new StringBuffer();
		
		if (status != null && !status.equals("")) {
			sql.append("SELECT v.id_venda, v.data, v.loja, v.pdv, v.status, i.id_item_venda, i.produto, i.preco_unitario, i.desconto ");
			sql.append("FROM tb_venda v, tb_item_Venda i ");
			sql.append("WHERE v.id_venda = i.id_venda and v.status = :status ");
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).addEntity(ItemVenda.class);
			
			query.setString("status", status);

			itens = query.list();

		}
		
		
		return itens;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> getAllItemVendas(Integer idVenda) {
		
		List<ItemVenda> itens = null;
		
		StringBuffer sql = new StringBuffer();
		
		if (idVenda != null) {
			sql.append("SELECT v.id_venda, v.data, v.loja, v.pdv, v.status, i.id_item_venda, i.produto, i.preco_unitario, i.desconto ");
			sql.append("FROM tb_venda v, tb_item_Venda i ");
			sql.append("WHERE v.id_venda = i.id_venda and i.id_venda = :idVenda ");
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).addEntity(ItemVenda.class);
			
			query.setInteger("idVenda", idVenda);

			itens = query.list();

		}
		
		
		return itens;
	}
	

	
	@SuppressWarnings("unchecked")
	public Integer maxId() {
		
		return (Integer)this.sessionFactory.getCurrentSession().createQuery("select max(v.id) from Venda v").list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Integer maxIdItem(Integer vendaId) {
		
		Query query = sessionFactory.
				getCurrentSession().createSQLQuery("select max(i.id_item_venda)+1 from tb_item_venda i where i.id_venda = "+vendaId);

		BigInteger i = (BigInteger)query.list().get(0);
		return i.intValue();
	}


}
