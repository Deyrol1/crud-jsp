
package modelosUsuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewUsuario")
public class ViewUsuario extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  List<Emp> list=EmpDao.getAllEmployees();
  request.setAttribute("lstEmployee", list);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/Usuario/viewEmployee.jsp");
  view.forward(request,response);
 }
}

