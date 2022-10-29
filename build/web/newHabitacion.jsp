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
    <h4 class="text-center">Agregar Nueva Habitacion</h4>
    <form action="SaveHabitacion" method="post">
        
        <div class="form-group">
      <label for="id">Id:</label>
      <input type="number" class="form-control" name="id" />
     </div>
         <div class="form-group">
      <label for="tipo">Tipo:</label>
      <select name="tipo" class="form-control">
       <option>Simple</option>
       <option>Doble</option>
       <option>Suite</option>
      </select>
     </div>
     
     <div class="form-group">
      <label for="nro">Nro:</label>
      <input type="number" class="form-control" name="nro" />
     </div>
         
     <div class="form-group">
      <label for="precio">Precio:</label>
      <input type="precio" class="form-control" name="precio" />
     </div>
      <div class="form-group">
      <label for="estado">Estado:</label>
      <select name="estado" class="form-control">
       <option>Disponible</option>
       <option>Ocupado</option>
      </select>
     </div>
     
     
  
     <div class="form-group">
      <input type="submit" class="btn btn-success" onclick="ViewHabitacion" value="Guardar Habitacion" />
     </div>
    </form>
   
    
   </div>
  </div>
 </div>
    
    
    
        
        
        
        
    </body>
</html>
