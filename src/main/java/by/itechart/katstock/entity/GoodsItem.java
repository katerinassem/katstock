package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
@Entity
@Table(name = "katstock.goods_item")
public class GoodsItem extends BaseEntity {

    private Long goodsItemId;
    private Integer weight;

    private Goods goods;


    @Id
    @SequenceGenerator(name = "goods_item_generator", sequenceName = "katstock.goods_item_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_item_generator")
    @Column(name = "goods_item_id")
    public Long getGoodsItemId() {
        return goodsItemId;
    }

    public void setGoodsItemId(Long goodsItemId) {
        this.goodsItemId = goodsItemId;
    }

    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @ManyToOne
    @JoinColumn(name = "goods_id", nullable = false)
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
