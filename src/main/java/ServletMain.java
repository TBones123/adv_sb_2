import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMain")
public class   ServletMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("work");


        req.setAttribute("asd", "oktenweb");
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);





    }
private DbConnection dbConnection = new DbConnection();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =
                req.getParameter("username");
//        System.out.println(username);
        dbConnection.save(username);
        req.setAttribute("allUsers", dbConnection.findAll() );

        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
