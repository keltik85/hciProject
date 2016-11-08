package my.app.service;


import my.app.dao.GreetingDao;
import my.app.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingsServiceImpl implements GreetingsService {

    @Autowired
    GreetingDao dao;

    public List<Greeting> getAllGreetings()
    {
        return dao.getAllGreetings();
    }
}
