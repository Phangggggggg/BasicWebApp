package muzoo.io.ooc.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File docBase = new File("/Users/phang/Desktop/BasicWebApp/Homework3/src/main/webapp");
        docBase.mkdirs(); // in case there is no directory, but this case there is which is WEB-INF

        try {
            Context ctx = tomcat.addWebapp("",docBase.getAbsolutePath());
            ServletRouter servletRouter = new ServletRouter();
            servletRouter.initialisation(ctx);
            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException | LifecycleException e) {
            e.printStackTrace();
        }

    }

}
