package my.app.controllers.angular;

import my.app.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PhoneController {


    @RequestMapping(value = "/getAllPhones", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Greeting> getAllPhones() {
        List<Greeting> someList = new ArrayList<Greeting>();
        someList.add(new Greeting("1","bla"));
        someList.add(new Greeting("2","blub"));
        return someList;
    }
}
