import java.io.IOException;

        import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name="ListServlet", displayName="ListServlet", urlPatterns = {"/list"}, loadOnStartup=1)
public class StartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("Hello, Bart" + getUsers());
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}