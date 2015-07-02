package entity;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class StockOrganization extends Entity {

    private Long stockOrganizationId;
    private String title;

    private Address address;


    public Long getStockOrganizationId() {
        return stockOrganizationId;
    }

    public void setStockOrganizationId(Long stockOrganizationId) {
        this.stockOrganizationId = stockOrganizationId;
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
}
