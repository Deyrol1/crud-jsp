
package modelosHabitacion;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteHabitacion")
public class DeleteHabitacion extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String idd=request.getParameter("id");
  int id=Integer.parseInt(idd);
  HabDao.delete(id);
  response.sendRedirect("ViewHabitacion");
 }
}
