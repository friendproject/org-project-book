package com.test.velocity.core;

import com.test.velocity.Handler.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by Ankur on 12-10-2015.
 */
public class WebContentHandler implements RequestHandler {
    private String mime;
    private String s;

    public WebContentHandler(String mime, String s) {

        this.mime = mime;
        this.s = s;
    }

    @Override
    public void handle(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {


        httpResponse.setContentType(mime);
        byte[] bytes = new byte[81960];

        InputStream inputStream = WebContentHandler.class.getResourceAsStream("/resources" + httpRequest.getRequestURI());
        int read;
        while ((read = inputStream.read(bytes)) >= 0) {
            httpResponse.getOutputStream().write(bytes, 0, read);
        }

    }
}
