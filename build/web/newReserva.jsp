 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>Proyecto CRUD</title>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
    <body>
       
        
    <div class="container-fluid">
  <div class="row-fluid"> 
   <div class="col-md-6">
    <h4 class="text-center">Agregar Nuevo Empleado</h4>
    <form action="SaveUsuario" method="post">
     <div class = "form-group">
      <label for="cedula">Cedula:</label>
      <input type="text" class="form-control" name="cedula" />
     </div>
     <div class="form-group">
      <label for="nombre">Nombre:</label>
      <input type="text" class="form-control" name="nombre" />
     </div>
     
     <div class="form-group">
      <label for="cargo">Cargo:</label>
      <select name="cargo" class="form-control">
       <option>Admin</option>
       <option>Recepcionista</option>
       <option>Limpieza</option>
      </select>
     </div>
     <div class="form-group">
      <input type="submit" class="btn btn-success" onclick="ViewUsuario" value="Guardar Empleado" />
     </div>
    </form>
   
    
   </div>
  </div>
 </div>
    
    
    
        
        
        
        
    </body>
</html>
