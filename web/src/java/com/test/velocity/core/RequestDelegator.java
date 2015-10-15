package com.test.velocity.core;

import com.test.velocity.Handler.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Ankur on 02-10-2015.
 */
public class RequestDelegator extends HttpServlet {
    private static Map<String, RequestHandler> handlerMap = new HashMap<>();

    public static void registerHandlers() {
        handlerMap.put("/login", new LoginPageCreater());
        handlerMap.put("/browse", new LoginRequestHandler());
        handlerMap.put("/webservice", new WebServiceHandler());
        handlerMap.put("/css", new WebContentHandler("css","/css/"));
        handlerMap.put("/fonts", new WebContentHandler("fonts","/fonts/"));
        handlerMap.put("/js", new WebContentHandler("js","/js/"));
        handlerMap
                .put("/favicon.ico", new WebContentHandler("/", "/"));
        handlerMap.put("/addBook", new AddBookPageCreater());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {


        StringTokenizer stringTokenizer=new StringTokenizer(request.getRequestURI(),"/");

        RequestHandler requestHandler = handlerMap.get("/"+stringTokenizer.nextElement());
        try {

            System.out.println(request.getRequestURI());
            requestHandler.handle(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

    }
}
