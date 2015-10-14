package com.test.velocity.Handler;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ankur on 02-10-2015.
 */
public interface RequestHandler  {


    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception;
}
