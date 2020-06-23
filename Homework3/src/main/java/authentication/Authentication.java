package authentication;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public boolean isAuthenticated(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        return session.getAttribute("username") != null;
    }

    public boolean login(String username, String password){
        String hash = userService.getPWD(username);
        if (username != null){
            if (userService.checkPassword(password,hash)){
                return userService.checkUser(username, hash);
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
