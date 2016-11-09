package my.app.main;


import com.mongodb.Mongo;
import my.app.model.angular.Phone;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@SpringBootApplication
@ComponentScan({"my.app.*"})
@Configuration
public class Application {

    @Autowired
    private Mongo mongo;

    @Autowired
    @Qualifier("myMongoOperationsBean")
    private static MongoOperations mongoOps;

    public
    @Bean
    MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        mongo.setPort(27017);
        return mongo;
    }

    @Bean
    @Qualifier("myMongoOperationsBean")
    public MongoOperations mongoOperations() {
        MongoOperations mongoOps = new MongoTemplate(mongo, "springdatabase");
        return mongoOps;
    }

    public static void main(String[] args) throws IOException {
        prepareMongoDBData();
        SpringApplication.run(Application.class, args);
    }

    private static void prepareMongoDBData() throws IOException {
        JSONArray phones = new JSONArray(
                IOUtils.toString(
                        Application.class.getResourceAsStream("../../../static/misc/phones.json"), "utf-8"));
        for (int i = 0; i < phones.length(); i++) {
            String currId = phones.getJSONObject(i).getString("id");
            Integer currAge = Integer.valueOf(phones.getJSONObject(i).getString("age"));
            String currSnippet = phones.getJSONObject(i).getString("snippet");
            String currName = phones.getJSONObject(i).getString("name");
            String currImageUrl = phones.getJSONObject(i).getString("imageUrl");
            insertIntoMongo(currId, currAge, currSnippet, currName, currImageUrl);
        }
    }

    private static void insertIntoMongo(String currId, Integer currAge, String currSnippet, String currName, String currImageUrl) {
        try {
            mongoOps.insert(new Phone(currId, currAge, currSnippet, currName, currImageUrl));
        } catch (Exception ex) {
            System.out.println("mongoOps.insert failed:\n" + ex.toString());
        }
    }
}