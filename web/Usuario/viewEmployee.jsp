<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelosUsuario.Emp"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
     <script src="https://kit.fontawesome.com/67da4421d0.js" crossorigin="anonymous"></script>
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Proyecto CRUD</title>
</head>
<body>
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="ViewUsuario">Usuario <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="ViewReserva">Reserva</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="ViewHabitacion">Habitacion</a>
                </li>
               
              </ul>
            </div>
          </nav>
    
    
    
    
    
	<%
		List<Emp> lstEmployee = (List<Emp>) request.getAttribute("lstEmployee");
	%>
	<div class="container-fluid">
		<hr>
		<div class="row-fluid">
			<div class="col-md-12">
				<a href='newEmployee.jsp' class="btn btn-success btn-xs">Nuevo
					Empleado</a>
				<h4 class="text-center">Lista de Empleados</h4>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Cedula</th>
							<th>Nombre</th>
							<th>Cargo</th>
							<th>Editar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					</tbody>
					<%
						for (Emp e : lstEmployee) {
							out.print("<tr><td>" + e.getCedula() + "</td><td>" + e.getNombre() + "</td><td>" + e.getCargo() + "</td><td><a href='EditUsuario?cedula=" + e.getCedula()
									+ "'>editar</a></td><td><a href='DeleteUsuario?cedula=" + e.getCedula() + "'>eliminar</a></td></tr>");
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>