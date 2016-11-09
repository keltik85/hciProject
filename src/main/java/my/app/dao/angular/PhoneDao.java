package my.app.dao.angular;


import my.app.model.angular.Phone;

import java.io.IOException;
import java.util.List;

public interface PhoneDao {
    List<Phone> getAllPhones() throws IOException;
}
