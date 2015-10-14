import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.test.velocity.Beans.Role;
import com.test.velocity.Beans.UserDetails;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Ankur on 03-10-2015.
 */
public class MongoDB {

    public static void main(String[] args) {


        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        MongoCollection<Document> a = db.getCollection("userDetails");

        UserDetails userDetails = new UserDetails("abcd", "abcd", "abcd", Role.ADMIN);

        a.insertOne(Document.parse(new GsonBuilder().create().toJson(userDetails)));


//        List<Address> list=new ArrayList<>();
//        list.add(new Address("Gurgaon","23"));
//        list.add(new Address("Delhi","25"));
//        list.add(new Address("Noida", "29"));
//        Person person=new Person("Ankur",22,list);
//        Person person1=new Person("Kamra",22,list);
//        Gson gson=new GsonBuilder().create();
//        Gson gson1=new Gson();
//
//        a.insertOne(Document.parse(gson.toJson(person)));
//        a.insertOne(Document.parse(gson.toJson(person1)));
//        FindIterable<Document> b;
//        b = a.find();
//        b.forEach(new Block<Document>() {
//            @Override
//            public void apply(Document document) {
//                System.out.println(document);
//            }
//        });
//
//        List<String> list1=new ArrayList<>();
//FindIterable findIterable=a.find(new Document("addresses.city","Gurgaon"));
//        findIterable.forEach(new Block<Document>() {
//            @Override
//            public void apply(Document document) {
//                list1.add(document.toJson());
//            }
//        });
//
//        Person person2=gson1.fromJson(list1.get(0), Person.class);
//        System.out.println(person2.toString());

    }
}
