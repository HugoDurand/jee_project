<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taches Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Taches List</h1>
	        <h3><a href="newTaches">New Taches</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Libelle</th>
	        	<th>Id_user</th>
	        	<th>Date</th>
	        	<th>Urgent</th>
	        	<th>Action</th>
	        	
				<c:forEach var="tache" items="${listTaches}" varStatus="status">
	        	<tr>
	        	
	        	<c:choose>
				    <c:when test="${tache.urgent== true}">

						<td style="color:red;">${status.index + 1}</td>
						<td style="color:red;">${tache.libelle}</td>
						<td style="color:red;">${tache.id_user}</td>
						<td style="color:red;">${tache.date}</td>
						<td style="color:red;">${tache.urgent}</td>
				    </c:when>    
				    <c:otherwise>
				        <td>${status.index + 1}</td>
						<td>${tache.libelle}</td>
						<td>${tache.id_user}</td>
						<td>${tache.date}</td>
						<td>${tache.urgent}</td>
				    </c:otherwise>
				</c:choose>
					
					
					
					<td>
						<a href="editTaches?id=${tache.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTaches?id=${tache.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
