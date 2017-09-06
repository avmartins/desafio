# Desafio

Realizar um exercício simples, de maneira a comprovar conhecimentos básicos nas tecnologias utilizadas na Empresa.

## Tecnologias Utilizadas

- Spring MVC, Restful, Jersey e MySQL

## Prerequisitos

É necessário as ferramentas mysql, maven, git e tomcat( ou outro servidor de aplicação ) estejam instalado na maquina.

Banco e Dados
-------------
 1) Instalar o MySql 
 2) Criar o usuário e senha : desafio / desafio
	Ou se prefirir alterar o arquivo jdbc.properties que está no diretório desafio\src\main\webapp\WEB-INF para as suas configurações de Banco.
 3) Executar o Script script_mysql.sql

Servidor Tomcat
---------------
Instalar o Tomcat versão 8 ou o que melhor se encaicar na instituição.

Executar por dentro do Eclipse ( IDE )
-------------------------------------------------------------------
	1) Instalar o Eclipse
	
	2) Baixar o fonte da aplicação :
	   git clone https://github.com/avmartins/desafio.git
	   
	3) Importar e abrir o projeto no eclipse   
	   
Gerar o arquivo war ( arquivo para deploy em um aplication server )
-------------------------------------------------------------------

	1) Pelo Eclipse
	
		- Executar mvn install
	   
	2) Entrar no diretório onde baixou o projeto e executar 
	   mvn clean install  	
	   
Executar a Aplicação	   
	   
	1) Copiar o arquivo desafio.war gerado no diretório \desafio\target para o diretório \apache-tomcat-8\webapps
	
	2) Executar o arquivo bat do diretorio : \apache-tomcat-8.5.14\bin\startup.bat ( OBS : CONFGURAÇÃO TODA PADRÃO WINDOWS )

Relatório
---------
	http://localhost:8080/desafio/list

Simular o Post com dados para inclusão de processamento
-------------------------------------------------------
	1) Pelo Eclipse
	   Executar o SimulationClient ( package br.com.desafio.server.endpoints.simulation )
	   
Diretorio dos arquivos gerados ( por convenção padrão windows )
------------------------------	   
	C:\processados - pra alterar entrar na classe ProcessamentoController.java e alterar o caminho como o tempo de execução da task
			 para melhorar o codigo criar um properties one vai ser colocado tais parametros
	
Configuração do Sistema
----------------------	
   - desafio-servlet.xml
   - jdbc.properties
   - web.xml ( Configuração de integração Spring x Jersey)
	
   <servlet>
        <servlet-name>desafio</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>desafio</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <context-param>
	    <param-name>contextConfigLocation</param-name>
	    <param-value>
	    	/WEB-INF/desafio-servlet.xml
	    </param-value>
	</context-param>
    <listener>
	    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<servlet>
    <servlet-name>Jersey REST Service</servlet-name>
        <servlet-class>com.sun.jersey.spi.spring.container.servlet.SpringServlet</servlet-class>
        <init-param>
            <param-name>com.sun.jersey.config.property.packages</param-name>
            <param-value>br.com.desafio.controller</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>Jersey REST Service</servlet-name>
        <url-pattern>/rest/*</url-pattern>
    </servlet-mapping>

## Autor

* **Anderson Virginio Martins** - (https://github.com/avmartins/desafio.git)

