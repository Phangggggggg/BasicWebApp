package muzoo.io.ooc.webapp;

import authentication.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListPageServlet extends AbstractRoutableServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUser = authentication.getUserService().getAllUser();
        req.setAttribute("allUser", allUser);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/listPage.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("username");
        String password = (String) httpSession.getAttribute("password");
        String edit = req.getParameter("edit");//get name
        String delete = req.getParameter("delete"); // get username
        String addUser = req.getParameter("addUser");
        if (delete != null) {
            if (authentication.login(username, password) && delete.equals(username)) {
                String cantDelete = "You can not be deleted";
                req.setAttribute("cantDelete", cantDelete);

            } else {
                authentication.getUserService().removeUser(delete);
                String canDelete = "Delete user is successful";
                req.setAttribute("canDelete", canDelete);
            }
        }
        if (addUser != null){
            resp.sendRedirect("/register");
        }
        if (edit != null){
            httpSession.setAttribute("targetName",edit);
            resp.sendRedirect("/edit");
        }
        doGet(req,resp);



    }

    @Override
    public String getPattern() {
        return "/listpage";
    }
}
