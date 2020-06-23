package muzoo.io.ooc.webapp;

import java.util.ArrayList;
import java.util.List;

public class ListServlet {

    private final List<Class<? extends AbstractRoutableServlet>> servletClasses = new ArrayList<>();
    public void addServlet(){
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(RegisterServlet.class);
        servletClasses.add(ListPageServlet.class);
        servletClasses.add(EditServlet.class);
    }

    public List<Class<? extends AbstractRoutableServlet>> getServletClasses() {
        addServlet();
        return servletClasses;
    }
}
