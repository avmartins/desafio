<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Relatório do Processamento</title>

<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		font: 14px/1.4 Georgia, Serif;
	}
	
	#page-wrap {
		margin: 50px;
	}
	
	p {
		margin: 20px 0;
	}
	
	/* 
		Generic Styling, for Desktops/Laptops 
		*/
	table {
		width: 100%;
		border-collapse: collapse;
	}
	table1 {
		width: 50%;
		border-collapse: collapse;
	}
	/* Zebra striping */
	tr:nth-of-type(odd) {
		background: #eee;
	}
	
	/* Zebra striping */
	tr1 {
		background: #fff;
	}
	
	
	th {
		background: #333;
		color: white;
		font-weight: bold;
	}
	
	td, th {
		padding: 6px;
		border: 1px solid #ccc;
		text-align: left;
	}
	td1 {
		padding: 10px;
		border: 0px solid #ccc;
		text-align: left;
	}
</style>

<script type="text/javascript">

//-----------------------------------------------------------------
//Entrada DD/MM/AAAA
//-----------------------------------------------------------------
function fctValidaData(obj)
{
 var data = obj.value;
 var dia = data.substring(0,2)
 var mes = data.substring(3,5)
 var ano = data.substring(6,10)

 //Criando um objeto Date usando os valores ano, mes e dia.
 var novaData = new Date(ano,(mes-1),dia);

 var mesmoDia = parseInt(dia,10) == parseInt(novaData.getDate());
 var mesmoMes = parseInt(mes,10) == parseInt(novaData.getMonth())+1;
 var mesmoAno = parseInt(ano) == parseInt(novaData.getFullYear());

 if (!((mesmoDia) && (mesmoMes) && (mesmoAno)))
 {
     alert('Data informada é inválida!');   
     obj.focus();    
     return false;
 }  
 return true;
}

function validaForm(frm) {
	if (!fctValidaData(document.getElementById("dataProcessamento"))) {
    	return false;
      }
}
</script>

</head>
<body>

	<h2>Relatório do Processamento</h2>
	<form:form method="post" action="list" commandName="processamentoDTO" onsubmit="return validaForm(this);">

		<table class="table1" style="width: 300px">
			<tr class="tr1">
				<td class="td1"><form:label path="dataProcessamento">
						<spring:message code="label.data" />
					</form:label></td>
				<td class="td1"><form:input path="dataProcessamento" /></td>
				<td class="td1"><input type="submit"
					value="<spring:message code="label.lista"/>" /></td>
			</tr>
		</table>
	</form:form>


	<h3><br>Lista do Relatório do Processamento</h3>
	<c:if test="${!empty processamentoList}">
		<table>
			<tr>
				<th>ID</th>
				<th>Data</th>
				<th>Produto</th>
				<th>Loja</th>
				<th>Pdv</th>
				<th>Valor</th>
				<th>Desconto</th>
				<th>Total</th>
				<th>Status</th>

			</tr>
			<c:forEach items="${processamentoList}" var="proc">
				<tr>
					<td>${proc.id}</td>
					<td>${proc.dataProcessamento}</td>
					<td>${proc.produto}</td>
					<td>${proc.loja}</td>
					<td>${proc.pdv}</td>
					<td>${proc.valorUnitario}</td>
					<td>${proc.valorDesconto}</td>
					<td>${proc.valorTotal}</td>
					<td>${proc.status}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>