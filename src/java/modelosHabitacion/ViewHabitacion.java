
package modelosHabitacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewHabitacion")
public class ViewHabitacion extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.setContentType("text/html");
  List<Hab> list=HabDao.getAllHabitaciones();
  request.setAttribute("lstHabitacion", list);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/Habitacion/viewHabitacion.jsp");
  view.forward(request,response);
 }
}

