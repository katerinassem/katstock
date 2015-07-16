package by.itechart.katstock.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.place")
public class Place extends BaseEntity {

    private Long placeId;
    private Integer placeNumber;
    private boolean available;
    private PlaceType placeType;

    private Stock stock;
    private StockItem stockItem;


    @Id
    @SequenceGenerator(name="place_generator", sequenceName="katstock.place_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_generator")
    @Column(name = "place_id")
    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    @Column(name = "place_number", nullable = false)
    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    @Column(name = "available", nullable = false)
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Column(name = "place_type", nullable = false)
    @Type(type = "by.itechart.katstock.util.hibernate.placetype.PlaceTypeEnumType")
    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @OneToOne
    @JoinColumn(name = "stock_item_id")
    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
}
