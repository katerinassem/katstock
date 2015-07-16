package by.itechart.katstock.web.service;

import by.itechart.katstock.entity.Place;
import by.itechart.katstock.entity.PlaceType;
import by.itechart.katstock.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getPlaces(PlaceType placeType, Long stockId) {

        return placeRepository.findByPlaceTypeAndStockStockId(placeType, stockId);
    }
}
