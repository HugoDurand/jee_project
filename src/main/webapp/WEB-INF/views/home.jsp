<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taches</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    </head>
    <body>
    
    <div class="container-fluid">
    	        <h1>Taches List</h1>
    	<div class="col-md-10 offset-md-1">
	        <h4><a href="newTaches">Ajouter une tache</a></h4>
	        <button class="btn btn-danger asltu" onclick="myFunction()">Afficher seulement les taches urgentes</button>
	        <table class="table">
	        	  <thead>
				    <tr>
				      <th scope="col">No</th>
				      <th scope="col">Libelle</th>
				      <th scope="col">Nom/Prenom User</th>
				      <th scope="col">Date</th>
				      <th scope="col">Urgent</th>
				      <th scope="col">Action</th>
				    </tr>
				  </thead>
	        	
	        	
	        	
				<c:forEach var="tache" items="${listTaches}" varStatus="status">
	        	  <tbody>
    				<tr>
	        	
	        	<c:choose>
				    <c:when test="${tache.urgent== true}">
				    

						<td class="urgent">${status.index + 1}</td>
						<td class="urgent">${tache.libelle}</td>
						<td class="urgent">${tache.user}</td>
						<td class="urgent">${tache.date}</td>
						<td class="urgent">${tache.urgent}</td>
						<td>
						<a href="editTaches?id=${tache.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTaches?id=${tache.id}">Delete</a>
						</td>
				    </c:when>    
				    <c:otherwise>
				    
				      <td class="normal">${status.index + 1}</td>
				      <td class="normal">${tache.libelle}</td>
				      <td class="normal">${tache.user}</td>
				      <td class="normal">${tache.date}</td>
				      <td class="normal">${tache.urgent}</td>
						<td class="normal">
						<a href="editTaches?id=${tache.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteTaches?id=${tache.id}">Delete</a>
						</td>
				    </c:otherwise>
				</c:choose>
							
	        	    </tr>
  				</tbody>
				</c:forEach>	        	
			</table>
    	</div>
    	</div>
    	
    	
    	
    	<style>
    	@import url('https://fonts.googleapis.com/css?family=Quicksand:500');
    	html,body{
    		width: 100%;
    		height:100%;
    		text-align: center;
    		font-family: 'Quicksand', sans-serif;
    	}
    	h4{
    	margin-top:5%;
    	margin-bottom:5%;
    	}
    	.urgent{
    	color:red;
    	}
    	.asltu{
    	margin-bottom:5vh;
    	float:right;
    	}
    	</style>
    	
    	<script>
    	function myFunction() {
    	    if ($(".normal").css('display') == 'none') {
    	    	$(".normal").show();
    	    	$(".asltu").attr('class', 'btn btn-danger asltu');
    	    	$(".asltu").text('Afficher seulement les taches urgentes');
    	    } else {
    	    	$(".normal").hide();
    	    	$(".asltu").attr('class', 'btn btn-info asltu');
    	    	$(".asltu").text('Afficher toutes les taches');
    	    }
    	}
    	</script>
    </body>
</html>
