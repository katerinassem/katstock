package entity;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class Organization extends Entity {

    private Long organizationId;
    private String title;
    private Address address;

    private StockOrganization stockOrganization;


    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
