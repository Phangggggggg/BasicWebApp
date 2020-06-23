package muzoo.io.ooc.webapp;

import DataBase.DataBase;
import Filter.CreateFilter;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

import javax.servlet.ServletException;
import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File docBase = new File("/Users/phang/Desktop/BasicWebApp/Homework3/src/main/webapp");
        docBase.mkdirs(); // in case there is no directory, but this case there is which is WEB-INF

        try {
            Context ctx = tomcat.addWebapp("",docBase.getAbsolutePath());
            ServletRouter servletRouter = new ServletRouter();
            servletRouter.initialisation(ctx);
            CreateFilter createFilter = new CreateFilter(servletRouter);
            FilterDef filterDef = new FilterDef();
            filterDef.setFilter(createFilter);
            filterDef.setFilterName(ServletRouter.class.getSimpleName());
            ctx.addFilterDef(filterDef);
            FilterMap filterMap = new FilterMap();
            filterMap.setFilterName(ServletRouter.class.getSimpleName());
            filterMap.addURLPattern("/*");
            ctx.addFilterMap(filterMap);


            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException | LifecycleException e) {
            e.printStackTrace();
        }




    }

}
