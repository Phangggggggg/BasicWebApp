package muzoo.io.ooc.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends AbstractRoutableServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(authentication.isAuthenticated(req)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/home.jsp");
            requestDispatcher.include(req, resp);
        }
        else{
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authentication.logout(req);
        resp.sendRedirect("/login");
    }

    @Override
    public String getPattern() {
        return "/index.jsp";
    }
}
