package muzoo.io.ooc.webapp;

import authentication.Authentication;

import javax.servlet.http.HttpServlet;
import java.util.List;

public abstract class AbstractRoutableServlet extends HttpServlet implements Routable {
    protected Authentication authentication;

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }






}
