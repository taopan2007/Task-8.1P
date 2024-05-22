package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.HandlerList;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

public class MyServer {

    private static int PORT = 8082;

    public void start() throws Exception {
        // HTTP server listening on port 8082.
        Server server = new Server(PORT);

        // URL routing/mapping handler
        ServletContextHandler servletHandler = new ServletContextHandler(server, "/");

        // Register /login URL path to end-point LoginServlet.
        servletHandler.addServlet(WelcomeServlet.class, "/");

        // Register /login URL path to end-point LoginServlet.
        servletHandler.addServlet(LoginServlet.class, "/login");

        // Register /reg URL path to end-point RegistrationServlet.
        servletHandler.addServlet(RegistrationServlet.class, "/reg");

        // Create a ResourceHandler for serving static files
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("webapp"); // Set the base directory for static files

        // Set up the HandlerList and add both the ResourceHandler and the ServletContextHandler
        HandlerList handlers = new HandlerList();
        handlers.addHandler(resourceHandler);
        handlers.addHandler(servletHandler);

        server.setHandler(handlers);

        System.out.println("Server started!");
        server.start();
        server.join();
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}
