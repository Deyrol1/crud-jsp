<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelosUsuario.Emp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Editar Empleado</title>
</head>
<body>
<%
		Emp employee = (Emp) request.getAttribute("employee");
	%>
	<div class="container-fluid">
		<div class="row-fluid">	
			<div class="col-md-6">
				<h4 class="text-center">Editar Empleado</h4>
				<form action="EditUsuario2" method="post">
				    <input type="hidden" name="cedula" value="<%= employee.getCedula() %>">
					
                                        <div class = "form-group">
						<label for="nombre">Nombre:</label>
						<input type="text" class="form-control" name="nombre" value="<%= employee.getNombre() %>"/>
					</div>
                                        <div class = "form-group">
						<label for="cargo">Cargo:</label>
						<input type="text" class="form-control" name="cargo" value="<%= employee.getCargo() %>"/>
					</div>
                                      
					
					
					<div class="form-group">
						<input type="submit" class="btn btn-success" value="Guardar Empleado" />
					</div>
				</form>
			
				<br />
				<a href="ViewUsuario">ver Empleados</a>
			</div>
		</div>
	</div>
</body>
</html>