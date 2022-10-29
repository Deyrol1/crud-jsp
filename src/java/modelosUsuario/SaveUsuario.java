package modelosUsuario;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveUsuario")
public class SaveUsuario extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  
  String sid=request.getParameter("cedula");
  int cedula=Integer.parseInt(sid);
  String nombre=request.getParameter("nombre");
  String cargo=request.getParameter("cargo");
 
  
  Emp e=new Emp();
  e.setCedula(cedula);
  e.setNombre(nombre);
  e.setCargo(cargo);
 
  
  int status=EmpDao.save(e);
  if(status>0){
  
    out.print("<p>Se guardo Correctamente!</p>");
    request.getRequestDispatcher("index.jsp").include(request, response);
  }else{
   out.println("No se pudo Guardar");
  }
  
  out.close();
 }

}

