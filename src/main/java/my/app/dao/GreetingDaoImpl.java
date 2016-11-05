package my.app.dao;

import my.app.model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class GreetingDaoImpl implements GreetingDao{
    public List<Greeting> getAllGreetings()
    {

        List<Greeting> greetings = new ArrayList<Greeting>();

        Greeting first = new Greeting(String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000)), "first");
        greetings.add(first);

        Greeting second = new Greeting(String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000)), "second");
        greetings.add(second);

        return greetings;
    }
}
