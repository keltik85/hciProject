package my.app.controllers.angular;

import my.app.model.angular.Phone;
import my.app.service.angular.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    PhoneService phoneService;

    @RequestMapping(value = "/getAllPhones", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Phone> getAllPhones() throws IOException {
        return phoneService.getAllPhones();
    }

    @RequestMapping(value = "/getPhoneDetail", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getPhoneDetail(@RequestParam(value="phoneId", required=true) String phoneId) throws IOException {
        return phoneService.getPhoneDetail(phoneId);
    }
}
