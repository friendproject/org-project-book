package com.test.velocity.Handler;//


import com.test.velocity.Beans.UserDetails;
import com.test.velocity.Builder.UserDetailsBuilder;
import com.test.velocity.Queries.ValidateUser;
import com.test.velocity.core.ContextHelper;
import com.test.velocity.exceptions.UserValidationException;
import org.apache.commons.lang.Validate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginRequestHandler extends HttpServlet implements RequestHandler {


    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {




        String userName = httpRequest.getParameter("userName");
        String password = httpRequest.getParameter("password");

        Validate.notEmpty(userName);
        Validate.notEmpty(password);


        try {
            UserDetails userDetails = new ValidateUser().getUserDetails(new UserDetailsBuilder().userName(userName).password(password).build());
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute("userDetail", userDetails);


            ContextHelper contextHelper = new ContextHelper();
            List<Integer> map = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                map.add(i);
            }

            contextHelper.initializeHeaderWithUserDetails(httpRequest);
            contextHelper.addListToContext(map);
            httpResponse.getWriter().write(contextHelper.populateTemplate("/resources/browse.vm"));
        } catch (UserValidationException e) {
            httpResponse.sendRedirect("/");
        }
    }


}