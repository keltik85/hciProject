package my.app.dao.angular;

import my.app.main.Application;
import my.app.model.angular.Phone;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @Override
    public String getPhoneDetail(String phoneId) throws IOException {
        JSONObject phoneDetail = new JSONObject(
                FileUtils.readFileToString(
                        new File(Application.class.getClassLoader().getResource(
                                "static/misc/phones/" + phoneId + ".json").getPath()),
                        "UTF-8"));
        return phoneDetail.toString();
        //TODO: insert the phone details into mongodb and return them by id
        //insertPhoneDetailIntoMongoDb(phoneId);
        //BasicQuery basicQuery = new BasicQuery("{map:{id:'"+phoneId+"'}}");
        //return mongoOps.findAll(Map.class, "jSONObject");
        /*return mongoOps.findOne(
                (new Query()).addCriteria(Criteria.where("id").is(phoneId.toString())),
                JSONObject.class);
                */

    }

    private void insertPhoneDetailIntoMongoDb(String phoneId) throws IOException {
        JSONObject phoneDetail = new JSONObject(
                FileUtils.readFileToString(
                        new File(Application.class.getClassLoader().getResource(
                                "static/misc/phones/" + phoneId + ".json").getPath()),
                        "UTF-8"));
        System.out.println("phoneDetail ---> " + phoneDetail);
        try {

            //String currAdditionalFeatures = phoneDetail.getString("additionalFeatures");
            //String currAndroidOs = phoneDetail.getJSONObject("android").getString("os");
            //String currAndroidUi = phoneDetail.getJSONObject("android").getString("ui");
            //String currId = phoneDetail.getString("id");
            mongoOps.insert(phoneDetail);
            //mongoOps.insert(new PhoneDetail(
                    //currAdditionalFeatures,
                    //new Android(currAndroidOs,currAndroidUi),
//
  //                  ));
        } catch (Exception ex){
            System.out.println("mongoOps.insert failed:\n" + ex.toString());
        }
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
            insertPhonesIntoMongo(currId, currAge, currSnippet, currName, currImageUrl);
        }
    }

    private void insertPhonesIntoMongo(String currId, Integer currAge, String currSnippet, String currName, String currImageUrl) {
        try {
            mongoOps.insert(new Phone(currId, currAge, currSnippet, currName, currImageUrl));
        } catch (Exception ex) {
            //System.out.println("mongoOps.insert failed:\n" + ex.toString());
        }
    }
}
