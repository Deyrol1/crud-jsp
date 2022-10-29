
package modelosHabitacion;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditHabitacion2")
public class EditHabitacion2 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  
  int id=Integer.parseInt(request.getParameter("id"));
  String tipo=request.getParameter("tipo");
  int nro=Integer.parseInt(request.getParameter("nro"));
  int precio=Integer.parseInt(request.getParameter("precio"));
  String estado=request.getParameter("estado");
  
  Hab h=new Hab();
  h.setId(id);
  h.setTipo(tipo);
  h.setNro(nro);
  h.setPrecio(precio);
  h.setEstado(estado);
 
  int status=HabDao.update(h);
  if(status>0){
   response.sendRedirect("ViewHabitacion");
  }else{
   out.println("Sorry! unable to update record");
  }
  
  out.close();
 }

}