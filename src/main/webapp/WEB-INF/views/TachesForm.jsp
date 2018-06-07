<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</head>
    <body>
    
    <div class="container-fluid">
		<h1>New/Edit Taches</h1>
    	<div class="col-md-2 offset-md-5">

		<form:form action="saveTaches" method="post" modelAttribute="taches">
		<form:hidden path="id"/>
			<div class="form-group">
				<label>Libelle:</label>
				<form:input path="libelle" class="form-control" />
			</div>
			<div class="form-group">
				<label>Nom/Prénom user:</label>
				<form:input path="user" class="form-control" />
			</div>
				<label>date:</label>
				<form:input path="date" class="form-control" />
			<div class="form-group">
				<label  style="color:red">Urgent:</label>
				<form:checkbox path="urgent" class="form-control"/>
			</div>
			<input class="btn btn-info" type="submit" value="Save">
		</form:form>
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
    	label{
    	margin-top:8vh;
    	}
    	.btn{
    	margin-top:5vh;
    	}
    	</style>
    </body>
</html>