package br.com.desafio.controller;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.desafio.dto.ItemDTO;
import br.com.desafio.dto.VendaDTO;
import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Processamento;
import br.com.desafio.entity.Venda;
import br.com.desafio.service.ProcessamentoManager;
import br.com.desafio.service.VendaManager;

@Path("/VendaService")
@Controller
public class VendaServiceController {

	@Autowired(required=true)
	private ProcessamentoManager processamentoManager;
	
	@Autowired(required=true)
	private VendaManager vendaManager;
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON) 
	public Response createVenda(String venda){ 
		
		try {
    		Gson gson = new GsonBuilder().create();
    		VendaDTO vendaGson = gson.fromJson(venda, VendaDTO.class);
    		
    		Processamento processamento = new Processamento();
    		processamento.setData(vendaGson.getData());
    		processamento.setLoja(vendaGson.getLoja());
    		processamento.setPdv(vendaGson.getPdv());
    		processamento.setStatus("OK");
    		processamento.setNomeArquivo("--");		
    		
    		Venda vendaBean = vendaManager.getVenda(vendaGson.getId_venda());
    		
    		if (vendaBean == null) {
    			vendaBean = new Venda();
    			vendaBean.setId(vendaManager.maxId().intValue()+1);
    			vendaBean.setData(vendaGson.getData());
    			vendaBean.setLoja(vendaGson.getLoja());
    			vendaBean.setPdv(vendaGson.getPdv());
    			vendaBean.setStatus("OK");
    			vendaManager.addVenda(vendaBean);
    		} else {
    			vendaBean.setStatus("OK");
    			vendaManager.updateVenda(vendaBean);
    		}
    		
    		processamentoManager.addProcessamento(processamento);
    		
    		for (ItemDTO item : vendaGson.getItens()) {
    			ItemVenda itemVenda = new ItemVenda();
    			
    			itemVenda.setVendaId(vendaBean.getId());
    			itemVenda.setItemVendaId(vendaManager.maxIdItem(vendaBean.getId()).intValue());
    			itemVenda.setPrecoUnitario(new BigDecimal(item.getPreco_unitario()));
    			itemVenda.setProduto(item.getProduto());
    			itemVenda.setValorDesconto(new BigDecimal(item.getPreco_unitario()));
    			
    			System.out.println(itemVenda.getVendaId());
    			System.out.println(itemVenda.getItemVendaId());
    			System.out.println(itemVenda.getPrecoUnitario());
    			System.out.println(itemVenda.getProduto());
    			System.out.println(itemVenda.getValorDesconto());
    			
    			vendaManager.addItemVenda(itemVenda);
    			
    		}
    		
    		System.out.println("OK Saiu");
    		return Response.status(200).entity(venda).build(); 

        } catch (Exception e) {
        	e.printStackTrace();
        	return Response.status(201).build();
        }

	}
	
	public void setProcessamentoManager(ProcessamentoManager processamentoManager) {
		this.processamentoManager = processamentoManager;
	}
	
	public void setVendaManager(VendaManager vendaManager) {
		this.vendaManager = vendaManager;
	}

}