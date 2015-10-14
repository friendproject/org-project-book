package com.test.velocity.Handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankur on 03-10-2015.
 */
public class WebServiceHandler implements RequestHandler {
    @Override
    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {

        httpResponse.setContentType("application/txt");


    }
}
