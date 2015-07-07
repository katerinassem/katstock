package by.itechart.katstock.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.stock_item")
public class StockItem extends BaseEntity {

    private Long StockItemId;
    private Integer quantity;
    private BigDecimal totalCost;

    private Goods goods;
    private Waybill waybill;
    private State state;


    @Id
    @SequenceGenerator(name="stock_item_generator", sequenceName="katstock.stock_item_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_item_generator")
    @Column(name = "stock_item_id")
    public Long getStockItemId() {
        return StockItemId;
    }

    public void setStockItemId(Long stockItemId) {
        StockItemId = stockItemId;
    }

    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "total_cost", nullable = false)
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @ManyToOne
    @JoinColumn(name = "goods_id", nullable = false)
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @ManyToOne
    @JoinColumn(name = "waybill_id", nullable = false)
    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
