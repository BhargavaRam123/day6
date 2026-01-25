package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App {

    public static void main(String[] args) throws LifecycleException {
        int port = 8080;

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);

        // Create a root context at "/" so endpoints are available at http://localhost:8080/hello
        Context context = tomcat.addContext("", System.getProperty("java.io.tmpdir"));

        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);

        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcher");

        tomcat.start();
        tomcat.getServer().await();
    }
}

