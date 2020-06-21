package muzoo.io.ooc.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditServlet extends AbstractRoutableServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/edit.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String edit = req.getParameter("edit");
        String editName = req.getParameter("editName");
        String targetName = (String) httpSession.getAttribute("targetName");
        if (edit != null){
            authentication.getUserService().editUser(targetName,editName);
            resp.sendRedirect("/listpage");
        }

    }

    @Override
    public String getPattern() {
        return "/edit";
    }
}
