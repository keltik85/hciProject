package my.app.main;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class ApplicationConfig {

    private @Autowired
    Mongo mongo;

    public @Bean MongoClientFactoryBean mongo() {
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



}
