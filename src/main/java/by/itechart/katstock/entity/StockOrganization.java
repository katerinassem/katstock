package by.itechart.katstock.entity;

import javax.persistence.*;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.stock_organization")
public class StockOrganization extends BaseEntity {

    private Long stockOrganizationId;
    private String title;

    private Address address;


    @Id
    @SequenceGenerator(name="stock_organization_generator", sequenceName="katstock.stock_organization_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_organization_generator")
    @Column(name = "stock_organization_id")
    public Long getStockOrganizationId() {
        return stockOrganizationId;
    }

    public void setStockOrganizationId(Long stockOrganizationId) {
        this.stockOrganizationId = stockOrganizationId;
    }

    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
