import model.PersonDao;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name="loginServlet", displayName="ListServlet", urlPatterns = {"/login"}, loadOnStartup=1)
public class loginController extends HttpServlet {


    @EJB
    PersonDao personDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long personid = Integer.parseInt(req.getParameter("personid"));

        try {
            req.setAttribute("loggedinuser", this.personDao.find(personid));

            req.getRequestDispatcher("/WEB-INF/loggedin.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}