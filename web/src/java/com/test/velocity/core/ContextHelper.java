package com.test.velocity.core;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by Ankur on 11-10-2015.
 */
public class ContextHelper {


    public VelocityContext velocityContext = new VelocityContext();

    public void initializeHeaderWithUserDetails(HttpServletRequest httpRequest) {

        velocityContext.put("userDetails", httpRequest.getSession().getAttribute("userDetail"));

    }


    public void addListToContext(List<Integer> map) {

        velocityContext.put("test", map);

    }

    public String populateTemplate(String templateName) throws Exception {

        StringWriter stringWriter=new StringWriter();
        Template template= VelocityEngineProvider.getVelocityEngine().getTemplate(templateName);
        template.merge(velocityContext,stringWriter);
        return stringWriter.toString();

    }




}
