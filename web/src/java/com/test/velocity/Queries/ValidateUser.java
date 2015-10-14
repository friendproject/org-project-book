package com.test.velocity.Queries;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.test.velocity.Beans.UserDetails;
import com.test.velocity.core.DocumentHelper;
import com.test.velocity.core.Exceptions;
import com.test.velocity.core.MongoDatabaseConnectionProvider;
import com.test.velocity.exceptions.UserValidationException;
import org.bson.Document;

import java.util.NoSuchElementException;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.test.velocity.core.DocumentHelper.toClassObject;

/**
 * Created by Ankur on 11-10-2015.
 */
public class ValidateUser {

    public UserDetails getUserDetails(UserDetails userDetails) throws Exception {

        MongoCollection collection = MongoDatabaseConnectionProvider.getDatabaseConnection().getCollection("login");
        MongoCursor fetchedDetails = collection.find(and(eq("userName", userDetails.getUserName()), eq("password", userDetails.getPassword()))).iterator();
        if (fetchedDetails.hasNext()) {
            Document document = (Document) fetchedDetails.next();
            return  (UserDetails) toClassObject(document, UserDetails.class);
        } else {
            throw new UserValidationException(Exceptions.getException(Exceptions.USER_NOT_VALIDATED));
        }
    }
}
