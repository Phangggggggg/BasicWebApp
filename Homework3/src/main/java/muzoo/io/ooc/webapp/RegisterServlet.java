package muzoo.io.ooc.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends AbstractRoutableServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/register.jsp");
        requestDispatcher.include(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = String.valueOf(req.getParameter("name"));
        String username = String.valueOf(req.getParameter("username"));
        String password = String.valueOf(req.getParameter("password"));
        try {
            if (!authentication.getUserService().checkUser(username,password) &&
                    !authentication.getUserService().checkRepeatedUN(username)){
                authentication.getUserService().addUser(name,username,password);
            }
            resp.sendRedirect("/listpage");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getPattern() {
        return "/register";
    }
}
