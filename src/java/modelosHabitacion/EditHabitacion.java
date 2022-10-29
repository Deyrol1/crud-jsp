
package modelosHabitacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditHabitacion")
public class EditHabitacion extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String idd=request.getParameter("id");
  int id=Integer.parseInt(idd);
  
  Hab h=HabDao.getHabitacionById(id);
  
  request.setAttribute("habitacion", h);
  RequestDispatcher view = getServletContext().getRequestDispatcher("/Habitacion/editHabitacion.jsp");
  view.forward(request, response);
 }
}
