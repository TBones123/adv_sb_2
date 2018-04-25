import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDelete")
public class ServletDelete extends HttpServlet {
    DbConnection dbConnection = new DbConnection();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String[] split = url.split("/");
        int id = Integer.valueOf(split[split.length -1]);
        dbConnection.delete(id);
        request.setAttribute("allUsers", dbConnection.findAll());
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }
}
