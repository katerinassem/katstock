package by.itechart.katstock.repository;

import by.itechart.katstock.entity.Place;
import by.itechart.katstock.entity.PlaceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
public interface PlaceRepository extends CrudRepository<Place, Long> {

    List<Place> findByPlaceTypeAndStockStockId(PlaceType placeType, Long stockId);
}
