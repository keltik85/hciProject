package my.app.dao.angular;

import com.mongodb.Mongo;
import my.app.model.angular.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class PhoneDaoImpl implements PhoneDao{


    @Autowired
    @Qualifier("myMongoOperationsBean")
    private MongoOperations mongoOps;

    @Override
    public List<Phone> getAllPhones() {
        /*
        MongoOperations mongoOps = new MongoTemplate(mongo, "springdatabase");
        try {
            mongoOps.insert(new Phone("1",123,"asd","dfg","cvbx"));
            mongoOps.insert(new Phone("2",456,"qweqwe","23423","khjk"));
            mongoOps.insert(new Phone("3",890890,"ghjfgj","jfghjfg","453275"));
        }catch(Exception ex){
            System.out.println("exception when inserting the stuff:\n\n" + ex.toString());
        }
        */
        return mongoOps.findAll(Phone.class);
    }
}
