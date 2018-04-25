import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUPdate")
public class ServletUPdate extends HttpServlet {
private DbConnection dbConnection = new DbConnection();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String[] split = url.split("/");
        String id = split[split.length - 1];
        Integer currID = Integer.valueOf(id);
        User user = dbConnection.findOne(currID);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("newName");
        dbConnection.update(id, name);
        req.setAttribute("allUsers", dbConnection.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
