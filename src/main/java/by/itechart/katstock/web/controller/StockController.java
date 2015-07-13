package by.itechart.katstock.web.controller;

import by.itechart.katstock.entity.Stock;
import by.itechart.katstock.entity.StockOrganization;
import by.itechart.katstock.entity.User;
import by.itechart.katstock.web.service.AuthenticationService;
import by.itechart.katstock.web.service.StockService;
import by.itechart.katstock.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private AuthenticationService authenticationService;

    @ResponseBody
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public List<Stock> stocks() {

        User user = authenticationService.getAuthorizedUser();

        if(user == null) {
            return null;
        }

        StockOrganization stockOrganization = user.getStockOrganization();
        if(stockOrganization == null) {
            return null;
        }

        return stockService.getStocks(stockOrganization.getStockOrganizationId());
    }

    @ResponseBody
    @RequestMapping(value = "/stock/{id}", method = RequestMethod.GET)
    public Stock stock(@PathVariable(value = "id") Long id) {

        return stockService.getStock(id);
    }
}
