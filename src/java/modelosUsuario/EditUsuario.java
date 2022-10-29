
package modelosUsuario;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditUsuario")
public class EditUsuario extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String cedulaa=request.getParameter("cedula");
  int cedula=Integer.parseInt(cedulaa);
  
  Emp e=EmpDao.getEmployeeByCedula(cedula);
  
  request.setAttribute("employee", e);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/Usuario/editEmployee.jsp");
  view.forward(request, response);
 }
}