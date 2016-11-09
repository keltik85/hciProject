package my.app.main;


import com.mongodb.Mongo;
import my.app.model.angular.Phone;

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

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        mongo.setPort(27017);
        return mongo;
    }

    @Bean
    @Qualifier("myMongoOperationsBean")
    public MongoOperations mongoOperations(){
        MongoOperations mongoOps = new MongoTemplate(mongo, "springdatabase");
        return mongoOps;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}