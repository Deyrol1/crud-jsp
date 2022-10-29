package modelosReserva;



import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveReserva")
public class SaveReserva extends HttpServlet {
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
  
 
  
  Res r=new Res();
  r.setId(id);
  r.setTipo(tipo);
  r.setNro(nro);
  r.setPrecio(precio);
  r.setEstado(estado);
 
  
  int status=ResDao.save(r);
  if(status>0){
  
    out.print("<p>Se guardo Correctamente!</p>");
    request.getRequestDispatcher("index.jsp").include(request, response);
  }else{
   out.println("No se pudo Guardar");
  }
  
  out.close();
 }

}

