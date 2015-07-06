package by.itechart.katstock.model;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class PlaceType extends Entity {

    private Long placeTypeId;
    private String placeTypeName;


    public Long getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Long placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }
}
