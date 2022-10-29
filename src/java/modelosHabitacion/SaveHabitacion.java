package modelosHabitacion;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveHabitacion")
public class SaveHabitacion extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  PrintWriter out=response.getWriter();
  
   String idd=request.getParameter("id");
  int id=Integer.parseInt(idd);
  String tipo=request.getParameter("tipo");
  String nroo=request.getParameter("nro");
  int nro=Integer.parseInt(nroo);
  String precioo=request.getParameter("precio");
  int precio=Integer.parseInt(precioo);
  String estado=request.getParameter("estado");
  
 
  
  Hab h=new Hab();
  h.setId(id);
  h.setTipo(tipo);
  h.setNro(nro);
  h.setPrecio(precio);
  h.setEstado(estado);
 
  
  int status=HabDao.save(h);
  if(status>0){
  
    out.print("<p>Se guardo Correctamente!</p>");
    request.getRequestDispatcher("index.jsp").include(request, response);
  }else{
   out.println("No se pudo Guardar");
  }
  
  out.close();
 }

}

