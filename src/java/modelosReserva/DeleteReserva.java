
package modelosReserva;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteReserva")
public class DeleteReserva extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String idd=request.getParameter("id");
  int id=Integer.parseInt(idd);
  ResDao.delete(id);
  response.sendRedirect("ViewReserva");
 }
}
