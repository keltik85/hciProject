package my.app.service.angular;

import my.app.dao.angular.PhoneDao;
import my.app.model.angular.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneDao dao;

    @Override
    public List<Phone> getAllPhones() throws IOException {
        return dao.getAllPhones();
    }
}
