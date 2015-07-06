package by.itechart.katstock.model;

import java.math.BigDecimal;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class Stock extends Entity {

    private Long stockId;
    private String stockName;
    private String description;
    private Integer square;
    private BigDecimal costPerKgPerDay;

    private Address address;
    private StockOrganization stockOrganization;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public BigDecimal getCostPerKgPerDay() {
        return costPerKgPerDay;
    }

    public void setCostPerKgPerDay(BigDecimal costPerKgPerDay) {
        this.costPerKgPerDay = costPerKgPerDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StockOrganization getStockOrganization() {
        return stockOrganization;
    }

    public void setStockOrganization(StockOrganization stockOrganization) {
        this.stockOrganization = stockOrganization;
    }
}
