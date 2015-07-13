package by.itechart.katstock.web.controller;

import by.itechart.katstock.entity.Address;
import by.itechart.katstock.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by katsiaryna.siamikina on 06.07.2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){

        return "index";
    }
}
