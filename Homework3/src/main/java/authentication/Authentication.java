package authentication;

import muzoo.io.ooc.webapp.AbstractRoutableServlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {
    private UserService userService;

    public Authentication(UserService userService) {
        this.userService = userService;
    }
    public String getCurrentUsername(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (String) session.getAttribute("username");
    }

    public boolean isAuthenticated(HttpServletRequest req){
        HttpSession session = req.getSession();
        return session.getAttribute("username") != null;
    }


    public boolean login(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.getUserByUsername(username);
        if (user.getPassword().equals(password)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username",username);
            return true;
        }
        else {
            return false;
        }

    }

    public void logout(HttpServletRequest req){
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("username");
        httpSession.invalidate();
    }

    public UserService getUserService() {
        return userService;
    }

}
