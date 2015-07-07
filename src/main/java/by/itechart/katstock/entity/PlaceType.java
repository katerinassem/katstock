package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.place_type")
public class PlaceType extends BaseEntity {

    private Long placeTypeId;
    private String placeTypeName;


    @Id
    @SequenceGenerator(name="place_type_generator", sequenceName="katstock.place_type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_type_generator")
    @Column(name = "place_type_id")
    public Long getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Long placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    @Column(name = "place_name", nullable = false, length = 50)
    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }
}
