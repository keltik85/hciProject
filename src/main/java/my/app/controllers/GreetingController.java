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

        model.addAttribute("name", greetingsService.getAllGreetings().get(0).getName());
        model.addAttribute("someproperty", greetingsService.getAllGreetings().get(1).getName());

        return "greeting";
    }
}
