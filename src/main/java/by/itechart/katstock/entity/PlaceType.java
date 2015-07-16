package by.itechart.katstock.entity;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
public enum PlaceType {

    OUTSIDE("outside"),
    INSIDE("inside"),
    REFRIGERATOR("refrigerator"),
    TANK("tank");

    protected String value;

    private PlaceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
