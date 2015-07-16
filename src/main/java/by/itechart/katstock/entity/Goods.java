package by.itechart.katstock.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.goods")
public class Goods extends BaseEntity {

    private Long goodsId;
    private Long uniqueNumber;
    private BigDecimal cost;
    private String description;
    private String storageConditions;

    private Measure measure;


    @Id
    @SequenceGenerator(name="goods_generator", sequenceName="katstock.goods_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_generator")
    @Column(name = "goods_id")
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "unique_number", nullable = false)
    public Long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Column(name = "cost", nullable = false)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "storage_conditions", length = 100)
    public String getStorageConditions() {
        return storageConditions;
    }

    public void setStorageConditions(String storageConditions) {
        this.storageConditions = storageConditions;
    }

    @ManyToOne
    @JoinColumn(name = "measure_id", nullable = false)
    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
