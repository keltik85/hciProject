package my.app.dao.angular;

import com.mongodb.Mongo;
import my.app.main.Application;
import my.app.model.angular.Phone;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class PhoneDaoImpl implements PhoneDao {

    @Autowired
    @Qualifier("myMongoOperationsBean")
    private MongoOperations mongoOps;

    @Override
    public List<Phone> getAllPhones() throws IOException {
        prepareMongoDBData();
        return mongoOps.findAll(Phone.class);
    }

    private void prepareMongoDBData() throws IOException {
        JSONArray phones = new JSONArray(
                IOUtils.toString(
                        Application.class.getResourceAsStream("../../../static/misc/phones.json"), "utf-8"));
        for (int i = 0; i < phones.length(); i++) {
            String currId = phones.getJSONObject(i).getString("id");
            Integer currAge = phones.getJSONObject(i).getInt("age");
            String currSnippet = phones.getJSONObject(i).getString("snippet");
            String currName = phones.getJSONObject(i).getString("name");
            String currImageUrl = phones.getJSONObject(i).getString("imageUrl");
            insertIntoMongo(currId, currAge, currSnippet, currName, currImageUrl);
        }
    }

    private void insertIntoMongo(String currId, Integer currAge, String currSnippet, String currName, String currImageUrl) {
        try {
            mongoOps.insert(new Phone(currId, currAge, currSnippet, currName, currImageUrl));
        } catch (Exception ex) {
            System.out.println("mongoOps.insert failed:\n" + ex.toString());
        }
    }
}
