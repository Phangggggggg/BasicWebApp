package muzoo.io.ooc.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends AbstractRoutableServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/login.jsp");
        requestDispatcher.include(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(authentication.login(username, password)){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);
            resp.sendRedirect("/");
        }
        else {
            String error = "Invalid username or password! Please try again";
            req.setAttribute("error", error);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/login.jsp");
            requestDispatcher.include(req,resp);
        }
    }

    @Override
    public String getPattern() {
        return "/login";
    }
}
