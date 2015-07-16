package by.itechart.katstock.web.controller;

import by.itechart.katstock.entity.Place;
import by.itechart.katstock.entity.PlaceType;
import by.itechart.katstock.web.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
@Controller
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @ResponseBody
    @RequestMapping(value = "/places/{placeType}/{stockId}")
    public List<Place> getPlacesByPlaceTypeAndStock(@PathVariable(value = "placeType")String placeType, @PathVariable(value = "stockId") Long stockId) {

        PlaceType placeTypeEnum = PlaceType.valueOf(placeType.toUpperCase());
        return placeService.getPlaces(placeTypeEnum, stockId);
    }
}
