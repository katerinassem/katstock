package by.itechart.katstock.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.stock")
public class Stock extends BaseEntity {

    private Long stockId;
    private String stockName;
    private String description;
    private Integer square;
    private BigDecimal costPerKgPerDay;
    private String photoUrl;

    private Address address;
    private StockOrganization stockOrganization;


    @Id
    @SequenceGenerator(name="stock_generator", sequenceName="katstock.stock_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_generator")
    @Column(name = "stock_id")
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "stock_name", nullable = false, length = 20)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Column(name = "description", length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "square")
    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    @Column(name = "cost_per_kg_per_day", nullable = false)
    public BigDecimal getCostPerKgPerDay() {
        return costPerKgPerDay;
    }

    public void setCostPerKgPerDay(BigDecimal costPerKgPerDay) {
        this.costPerKgPerDay = costPerKgPerDay;
    }

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "stock_organization_id", nullable = false)
    public StockOrganization getStockOrganization() {
        return stockOrganization;
    }

    public void setStockOrganization(StockOrganization stockOrganization) {
        this.stockOrganization = stockOrganization;
    }

    @Column(name = "photo_url", length = 500)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
