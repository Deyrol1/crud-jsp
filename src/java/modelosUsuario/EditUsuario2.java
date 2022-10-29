
package modelosUsuario;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditUsuario2")
public class EditUsuario2 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  
  int cedula=Integer.parseInt(request.getParameter("cedula"));
  String nombre=request.getParameter("nombre");
  String cargo=request.getParameter("cargo");
  
  Emp e=new Emp();
  e.setCedula(cedula);
  e.setNombre(nombre);
  e.setCargo(cargo);
 
  int status=EmpDao.update(e);
  if(status>0){
   response.sendRedirect("ViewUsuario");
  }else{
   out.println("Sorry! unable to update record");
  }
  
  out.close();
 }

}