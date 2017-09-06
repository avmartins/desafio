package br.com.desafio.server.endpoints.simulation;

import java.util.logging.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SimulationClient {

	public static final Logger logger = Logger.getLogger(SimulationClient.class.getCanonicalName());

    public static void main(String[] args) {
        Client c = Client.create();
        WebResource r = c.resource("http://localhost:8080/desafio/rest/VendaService");

        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
	    sb.append("\"id_venda\": 2,");
	    sb.append("\"data\": \"2017-06-26T10:17:48-03:00\",");
	    sb.append("\"loja\": 545,");
	    sb.append("\"pdv\": 4,");
	    sb.append("\"itens\": [");
	    sb.append("{");
	    sb.append("\"produto\": \"0112348576\",");
	    sb.append("\"preco_unitario\": 1.99,");
	    sb.append("\"desconto\": 1.00");
	    sb.append("},");
	    sb.append("{");
	    sb.append("\"produto\": \"0980987654\",");
	    sb.append("\"preco_unitario\": 9.99,");
	    sb.append("\"desconto\": 1.99");
	    sb.append("},");
	    sb.append("{");
	    sb.append("\"produto\": \"9182909878\",");
	    sb.append("\"preco_unitario\": 1.00,");
	    sb.append("\"desconto\": 0.00");
	    sb.append("},");
	    sb.append("{");
	    sb.append("\"produto\": \"098712312\",");
	    sb.append("\"preco_unitario\": 6.99,");
	    sb.append("\"desconto\": 2.00");
	    sb.append("}");
	    sb.append("]");
	    sb.append("}");

        getSimulation(r, sb.toString());

    }


    public static void getSimulation(WebResource r, String simulation) {
        // Test the POST method

    	try {
			
			ClientResponse response = r.type("application/json").post(ClientResponse.class, simulation);
	
	        logger.info("POST status: {0}" + response.getStatus());
	        if (response.getStatus() == 200) {
	            logger.info("POST succeeded");
	
	            //String entity = response.getEntity(Simulation.class);
	
	            //System.out.println(entity.getCompany() + ": " + entity.getContract());
	        } else {
	            logger.info("POST failed");
	        }
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
