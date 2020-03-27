<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Usuarios</title>
  </head>
  <body>
    <div class="container mt-3">
    	<div class="row">
    		<a class="btn btn-primary" href="CrearUsuario">Crear usuario</a>
    	</div>
    	<div class="row">
    		<div class="col-4 offset-8">
    			<form action="BuscarUsuarios" method="POST" class="form-inline">
    				<input type="text" name="query" class="form-control" placeholder="buscar usuarios">
    				<button type="submit" class="btn btn-primary mx-2">Buscar</button>    				
    			</form>
    		</div>
    	</div>
    		<h1>Usuarios</h1>
	
		<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">nombre apellido</th>
	      <th scope="col">dni</th>
	      <th scope="col">codigo</th>
	      <th scope="col">acciones</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <c:forEach items="${usuarios}" var="usuario">
	  
	    <tr>
	      <th><a href="VerUsuario?id=${usuario.getId()}">${usuario.getNombreApellido()}</a></th>
	      <td>${usuario.getDni()}</td>
	      <td>${usuario.getCodigo()}</td>
	      <td>
	      	<a class="btn btn-primary" href="VerUsuario?id=${usuario.getId()}">Ver</a>
	      	<a class="btn btn-secondary" href="EditarUsuario?id=${usuario.getId()}">Editar</a>
	      	<a class="btn btn-danger" href="EliminarUsuario?id=${usuario.getId()}">Eliminar</a>
	      </td>
	    </tr>
	   </c:forEach>
	   
	  </tbody>
	</table>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>