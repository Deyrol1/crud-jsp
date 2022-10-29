
package modelosReserva;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewReserva")
public class ViewReserva extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  List<Res> list=ResDao.getAllReservas();
  request.setAttribute("lstReserva", list);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/Reserva/viewReserva.jsp");
  view.forward(request,response);
 }
}

