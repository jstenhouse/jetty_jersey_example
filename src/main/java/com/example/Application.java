package com.example;

import com.example.api.HelloWorld;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by jason on 6/27/15.
 */
public class Application {

    public static void main(String[] args) {
        try {
            ResourceConfig resourceConfig = new ResourceConfig();
            resourceConfig.packages(HelloWorld.class.getPackage().getName());
            resourceConfig.register(JacksonFeature.class);

            ServletContainer servletContainer = new ServletContainer(resourceConfig);
            ServletHolder servletHolder = new ServletHolder(servletContainer);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
            context.setContextPath("/");
            context.addServlet(servletHolder, "/*");

            Server server = new Server(8080);
            server.setHandler(context);

            server.start();
            server.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
