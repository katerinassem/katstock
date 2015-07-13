package by.itechart.katstock.web.controller;

import by.itechart.katstock.entity.User;
import by.itechart.katstock.web.service.AuthenticationService;
import by.itechart.katstock.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by katsiaryna.siamikina on 13.07.2015.
 */
@Controller
public class UserInfoController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user-info", method = RequestMethod.GET)
    public User getUserInfo() {

        User user = authenticationService.getAuthorizedUser();

        if(user != null) {
            return user;
        }

        return null;
    }
}
