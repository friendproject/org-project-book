package com.test.velocity.Handler;

import com.test.velocity.core.VelocityEngineProvider;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by Ankur on 15-10-2015.
 */
public class AddBookPageCreater implements RequestHandler{


    @Override
    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {

        Template template= VelocityEngineProvider.getVelocityEngine().getTemplate("/resources/addBook.vm");
        VelocityContext velocityContext=new VelocityContext();
        velocityContext.put("date", new Date());
        StringWriter stringWriter=new StringWriter();
        template.merge(velocityContext,stringWriter);
        httpResponse.getWriter().write(stringWriter.toString());
    }
}
