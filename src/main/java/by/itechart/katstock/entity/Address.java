package by.itechart.katstock.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.address")
public class Address extends BaseEntity {

    private Long addressId;
    private String country;
    private String region;
    private String street;
    private String building;
    private String description;


    @Id
    @SequenceGenerator(name="address_generator", sequenceName="katstock.address_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @Column(name = "address_id")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Column(name = "country", nullable = false, length = 15)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "region", nullable = false, length = 50)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "street", length = 20)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "building", length = 10)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column(name = "description", length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
