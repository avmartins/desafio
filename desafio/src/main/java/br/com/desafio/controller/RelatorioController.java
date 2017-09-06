package br.com.desafio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.desafio.dto.ProcessamentoDTO;
import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Venda;
import br.com.desafio.service.VendaManager;
import br.com.desafio.util.DateUtils;
import br.com.desafio.util.TypeConverter;

@Controller
public class RelatorioController {

	private  static final Logger LOGGER = Logger.getLogger(RelatorioController.class.getName());
			
	@Autowired(required=true)
	private VendaManager vendaManager;
	
	public void setVendaManager(VendaManager vendaManager) {
		this.vendaManager = vendaManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listProcessamentos(ModelMap map) {
		
		List<ProcessamentoDTO> lista = new ArrayList<ProcessamentoDTO>();
		map.addAttribute("processamentoDTO", new ProcessamentoDTO());
		map.addAttribute("processamentoList", lista);

		return "relatorioProessamentoList";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String listProcessamentosPost(@ModelAttribute(value = "processamentoDTO") ProcessamentoDTO form, ModelMap map) {
		
		StringBuffer sParametros = new StringBuffer();
		
		sParametros.append(form.getDataProcessamento());
		sParametros.append(" | ");
		sParametros.append(form.getDataProcessamento());
		sParametros.append(" | ");
		sParametros.append(form.getDataProcessamento());
		
        LOGGER.log(Level.INFO, "listProcessamentosPost ", sParametros.toString());
		
		Date dataI = null;
		Date dataF = null;
        List<ItemVenda> vendas = null;

        try {
            dataI = DateUtils.toStringDate(form.getDataProcessamento()+ " 00:00:00");
            dataF = DateUtils.toStringDate(form.getDataProcessamento()+ " 23:59:59");
            
            java.sql.Date dataPesquisaI = new java.sql.Date(dataI.getTime());
            java.sql.Date dataPesquisaF = new java.sql.Date(dataF.getTime());
            
            vendas = vendaManager.getAllItemVendas(dataPesquisaI, dataPesquisaF);

            LOGGER.log(Level.INFO, " Total vendas {0} ", vendas.toString());

            if (vendas != null) {
            	map.addAttribute("processamentoList", transformer(vendas));
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }


        map.addAttribute("processamentoDTO", new ProcessamentoDTO());
		


		return "relatorioProessamentoList";
	}
	
    private List<ProcessamentoDTO> transformer(List<ItemVenda> vendas) throws Exception {

    	List<ProcessamentoDTO> lista = new ArrayList<ProcessamentoDTO>();

        for (ItemVenda processamento : vendas){
        	
        	Venda venda = vendaManager.getVenda(processamento.getVendaId());
        	ProcessamentoDTO dto = new ProcessamentoDTO();
        	dto.setDataProcessamento(TypeConverter.toStringDateTime(venda.getData()));
        	dto.setValorDesconto(TypeConverter.toString(processamento.getValorDesconto()));
        	dto.setValorUnitario(TypeConverter.toString(processamento.getPrecoUnitario()));
        	dto.setProduto(processamento.getProduto());
        	dto.setLoja(TypeConverter.toString(venda.getLoja()));
        	dto.setPdv(TypeConverter.toString(venda.getPdv()));
        	dto.setValorTotal(TypeConverter.toString(processamento.getValorTotal()));
        	dto.setId(TypeConverter.toString(processamento.getItemVendaId()));
        	dto.setStatus(venda.getStatus());
        	lista.add(dto);

        }
        
        return lista;

    }

}

