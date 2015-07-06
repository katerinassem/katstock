package by.itechart.katstock.model;

import java.math.BigDecimal;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class StockItem extends Entity {

    private Long StockItemId;
    private Integer quantity;
    private BigDecimal totalCost;

    private Goods goods;
    private Waybill waybill;
    private State state;


    public Long getStockItemId() {
        return StockItemId;
    }

    public void setStockItemId(Long stockItemId) {
        StockItemId = stockItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
