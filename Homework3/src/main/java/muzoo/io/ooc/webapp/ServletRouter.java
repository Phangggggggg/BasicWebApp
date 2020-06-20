package muzoo.io.ooc.webapp;

import authentication.Authentication;
import authentication.UserService;
import org.apache.catalina.*;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.deploy.NamingResourcesImpl;
import org.apache.catalina.startup.Tomcat;
import org.apache.juli.logging.Log;
import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.JarScanner;
import org.apache.tomcat.util.descriptor.web.*;
import org.apache.tomcat.util.http.CookieProcessor;
import sun.security.jca.GetInstance;

import javax.management.ObjectName;
import javax.servlet.*;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpServlet;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

public class ServletRouter extends HttpServlet {


    private final List<Class<? extends AbstractRoutableServlet>> servletClasses = new ArrayList<>();
    public void initialisation(Context context)  {
        FakeDataBase fakeDataBase = new FakeDataBase();
        UserService userService = new UserService(fakeDataBase);
        Authentication authentication = new Authentication(userService);
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(RegisterServlet.class);
        for (Class<? extends AbstractRoutableServlet>  servletClass : servletClasses) {
            AbstractRoutableServlet httpServlet = null;
            try {
                httpServlet = servletClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            httpServlet.setAuthentication(authentication);
            Tomcat.addServlet(context,httpServlet.getClass().getName(),httpServlet);
            context.addServletMapping(httpServlet.getPattern(),httpServlet.getClass().getName());
        }

        }


}
