package by.itechart.katstock.web.controller;

import by.itechart.katstock.web.controller.model.AuthenticationBundle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by katsiaryna.siamikina on 08.07.2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody AuthenticationBundle authenticationBundle){

        System.out.println("logged as " + authenticationBundle.getEmail());
        return "index";
    }
}
