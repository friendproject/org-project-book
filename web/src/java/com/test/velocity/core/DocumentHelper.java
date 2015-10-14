package com.test.velocity.core;

import com.google.gson.Gson;

import org.bson.Document;

/**
 * Created by Ankur on 11-10-2015.
 */
public class DocumentHelper {


    public static  Object toClassObject(Document document,Class classs){
        return new Gson().fromJson (document.toJson(),classs);
    }
}
