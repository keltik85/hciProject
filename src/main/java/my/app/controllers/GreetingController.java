package my.app.controllers;

import my.app.model.Greeting;
import my.app.service.GreetingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    GreetingsService greetingsService;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "unknown guy!") String name, Model model) {

        //doMongoInMemoryStuff();

        model.addAttribute("name", greetingsService.getAllGreetings().get(0).getName());
        model.addAttribute("someproperty", greetingsService.getAllGreetings().get(1).getName());

        return "greeting";
    }
/*
    private void doMongoInMemoryStuff() {
        TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

        //build the EntityManagerFactory as you would build in in Hibernate Core
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogm-jpa-tutorial");

        //Persist entities the way you are used to in plain JPA
        try {
            tm.begin();
            System.out.println("About to store a greeting");
            EntityManager em = emf.createEntityManager();
            Greeting someGreeting = new Greeting(1,"asdsadas");
            //someGreeting.setId(Long.valueOf(1));
            someGreeting.setName("blabla");
            em.persist(someGreeting);
            em.flush();
            em.close();
            tm.commit();

            //Retrieve your entities the way you are used to in plain JPA
            System.out.println("About to retrieve a greeting");
            tm.begin();
            em = emf.createEntityManager();
            Greeting someGreetingRetrieved = em.find(Greeting.class, someGreeting.getId());
            System.out.println("Found greeting " + someGreetingRetrieved.getName() + "!");
            em.flush();
            em.close();
            tm.commit();

            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
