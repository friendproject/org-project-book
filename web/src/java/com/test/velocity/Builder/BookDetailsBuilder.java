package com.test.velocity.Builder;

import com.test.velocity.Beans.BookDetails;

import java.util.Collection;

/**
 * Created by Ankur on 15-10-2015.
 */
public class BookDetailsBuilder {

    String title;

    String printYear;

    String author;

    String stream;

    Collection<String> fileNames;

    public BookDetailsBuilder title(String title) {
        this.title=title;
        return this;
    }

    public BookDetailsBuilder printYear(String printYear) {
        this.printYear=printYear;
        return this;
    }

    public BookDetailsBuilder author(String author) {
        this.author=author;
        return this;
    }

    public BookDetailsBuilder fileNames(Collection<String> fileNames) {
        this.fileNames=fileNames;
        return this;
    }

    public BookDetails build() {

        return new BookDetails(title,printYear,author,stream,fileNames);
    }

}
