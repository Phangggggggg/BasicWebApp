package muzoo.io.ooc.webapp;

import HashAndSalt.BCrypt;
import authentication.UserService;

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
        UserService userService = authentication.getUserService();
        try {
            if (!userService.checkUser(username,password) &&
                    !userService.checkRepeatedUN(username)){
                String hashSaltPwd = userService.hashSaltCal(password);
                authentication.getUserService().addUser(name,username,hashSaltPwd);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/listpage");

    }

    @Override
    public String getPattern() {
        return "/register";
    }
}
