package com.test.velocity.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Ankur on 29-09-2015.
 */
public class Main {


    public static void main(String arg[]) throws Exception {

        Server server = new Server(8000);


        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);


        HashSessionIdManager hashSessionIdManager = new HashSessionIdManager();
        SessionHandler sessionHandler = new SessionHandler();
        SessionManager sessionManager = new HashSessionManager();
        sessionManager.setSessionIdManager(hashSessionIdManager);
        sessionHandler.setSessionManager(sessionManager);
        sessionHandler.setHandler(handler);
        sessionHandler.setServer(server);
        server.setSessionIdManager(hashSessionIdManager);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context .addServlet(new ServletHolder(RequestDelegator.class), "/*");
        server.setHandler(context);
        ///handler.setHandler(sessionHandler);
        ///server.setSessionIdManager(hashSessionIdManager);

        RequestDelegator.registerHandlers();

        //RequestDelegator.getVelocityEngine();


        server.start();


    }


}
