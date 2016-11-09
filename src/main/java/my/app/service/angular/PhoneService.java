package my.app.service.angular;


import my.app.model.angular.Phone;

import java.io.IOException;
import java.util.List;


public interface PhoneService {
    public List<Phone> getAllPhones() throws IOException;
}
