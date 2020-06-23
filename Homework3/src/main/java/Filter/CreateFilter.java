package Filter;

import muzoo.io.ooc.webapp.AbstractRoutableServlet;
import muzoo.io.ooc.webapp.ListServlet;
import muzoo.io.ooc.webapp.ServletRouter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateFilter implements Filter {
    private List<Class<? extends AbstractRoutableServlet>> servletClasses;
    private ServletRouter servletRouter;
    private Map<String, HttpServlet> httpServletMap;
    public CreateFilter(ServletRouter servletRouter) {
        this.servletRouter = servletRouter;
        ListServlet listServlet = new ListServlet();
        servletClasses = listServlet.getServletClasses();
        httpServletMap = servletRouter.getMyMap();
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String URII = req.getRequestURI();
        if (!httpServletMap.containsKey(URII)){
            res.sendRedirect("/listpage");
        }
        else {
            httpServletMap.get(URII).service(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
