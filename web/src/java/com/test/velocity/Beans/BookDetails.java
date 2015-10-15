package com.test.velocity.Beans;

import java.util.Collection;

/**
 * Created by Ankur on 15-10-2015.
 */
public class BookDetails {

    String title;

    String printYear;

    String author;

    String stream;

    Collection<String> fileNames;

    public BookDetails(String title, String printYear, String author, String stream, Collection<String> fileNames) {
        this.title = title;
        this.printYear = printYear;
        this.author = author;
        this.stream = stream;
        this.fileNames = fileNames;
    }
}
