package com.test.velocity.Handler;

import com.test.velocity.Beans.Role;
import com.test.velocity.Beans.UserDetails;
import com.test.velocity.core.VelocityEngineProvider;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.eclipse.jetty.http.HttpParser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankur on 02-10-2015.
 */
public class BrowseRequestHandler extends HttpServlet implements RequestHandler {

    @Override
    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
        Template template= VelocityEngineProvider.getVelocityEngine().getTemplate("/resources/browse.vm");
        VelocityContext velocityContext= (VelocityContext) httpRequest.getAttribute("context");
        List<UserDetails> list=new ArrayList<>();
        for(int i=0;i<5;i++) {
            UserDetails userDetails = new UserDetails("" + i, "" + i, "" + i, Role.ADMIN);
            list.add(userDetails);
        }
        velocityContext.put("UserDetailsCollection", list);
        StringWriter stringWriter=new StringWriter();
        template.merge(velocityContext,stringWriter);
        httpResponse.setContentType("text/html");
        httpResponse.getWriter().write(stringWriter.toString());
    }
}
