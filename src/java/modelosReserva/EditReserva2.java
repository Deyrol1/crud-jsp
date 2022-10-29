
package modelosReserva;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditReserva2")
public class EditReserva2 extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  
  int id=Integer.parseInt(request.getParameter("id"));
  String fecha_inicio=request.getParameter("fecha_inicio");
  String fecha_fin=request.getParameter("fecha_fin");
  String nombre_cliente=request.getParameter("nombre_cliente");
  String tipo_habitacion=request.getParameter("tipo_habitacion");
  int num_habitacion=Integer.parseInt(request.getParameter("num_habitacion"));
  int dias=Integer.parseInt(request.getParameter("dias"));
  int valor_total=Integer.parseInt(request.getParameter("valor_total"));
  
  
  
  Res r=new Res();
  r.setId(id);
  r.setFecha_inicio(fecha_inicio);
  r.setFecha_fin(fecha_fin);
  r.setNombre_cliente(nombre_cliente);
  r.setTipo_habitacion(tipo_habitacion);
  r.setNum_habitacion(num_habitacion);
  r.setDias(dias);
  r.setValor_total(valor_total);
 
  int status=ResDao.update(r);
  if(status>0){
   response.sendRedirect("ViewReserva");
  }else{
   out.println("Sorry! unable to update record");
  }
  
  out.close();
 }

}