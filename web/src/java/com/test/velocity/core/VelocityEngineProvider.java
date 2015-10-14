package com.test.velocity.core;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Created by Ankur on 11-10-2015.
 */
public class VelocityEngineProvider {

    private static VelocityEngine velocityEngine;

    static {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        try {
            velocityEngine.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static VelocityEngine getVelocityEngine() {

        return velocityEngine;
    }
}
