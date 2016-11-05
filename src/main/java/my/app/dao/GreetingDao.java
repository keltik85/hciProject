package my.app.dao;

import my.app.model.Greeting;
import java.util.List;

public interface GreetingDao {
    List<Greeting> getAllGreetings();
}
