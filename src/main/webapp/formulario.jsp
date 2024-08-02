<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD de producto</title>
</head>
<s:head/>
<sx:head/>
<body>
<sx:tabbedpanel id="formProducto">
	<sx:div label="Formulario CRUD producto">
		<s:form action="alta.action" method="post">
			<s:push value="producto">
				<s:hidden key="id"></s:hidden>
				<s:textfield key="nombre" label="NOMBRE"></s:textfield>
				<s:textfield key="precio" label="PRECIO"></s:textfield>
				<s:submit value="Aceptar"/>
				<s:reset value="Limpiar"/>
				
			</s:push>
		</s:form>
	</sx:div>
</sx:tabbedpanel>

<table>

	<tr>
		<td>ID</td>
		<td>NOMBRE</td>
		<td>PRECIO</td>
		
	</tr>
	<s:iterator value="listaProducto">
	<tr>
		<td><s:property value="id"/></td>
		<td><s:property value="nombre"/></td>
		<td><s:property value="precio"/></td>
		
		<td>
			<s:url id="editURL" action="editar">
				<s:param name="id" value="%{id}"></s:param>
			</s:url>
			<s:a href="%{editURL}">Editar</s:a>
		</td>
		<td>
			<s:url id="deleteURL" action="baja">
				<s:param name="id" value="%{id}"></s:param>
			</s:url>
			<s:a href="%{deleteURL}">Eliminar</s:a>
		</td>
	</tr>
	
	</s:iterator>

</table>


</body>
</html>