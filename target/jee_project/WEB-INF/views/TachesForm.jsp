<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Taches</h1>
		<form:form action="saveTaches" method="post" modelAttribute="taches">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Libelle:</td>
				<td><form:input path="libelle" /></td>
			</tr>
			<tr>
				<td>id_user:</td>
				<td><form:input path="id_user" /></td>
			</tr>
			<tr>
				<td>date:</td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td>Urgent:</td>
				<td><form:input path="urgent" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>