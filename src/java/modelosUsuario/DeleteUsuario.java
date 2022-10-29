package modelosUsuario;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUsuario")
public class DeleteUsuario extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String cedulaa=request.getParameter("cedula");
  int cedula=Integer.parseInt(cedulaa);
  EmpDao.delete(cedula);
  response.sendRedirect("ViewUsuario");
 }
}