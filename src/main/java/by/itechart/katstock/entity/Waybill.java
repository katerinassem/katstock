package by.itechart.katstock.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
@Entity
@Table(name = "katstock.waybill")
public class Waybill extends BaseEntity {

    private Long waybillId;
    private BigDecimal totalCost;
    private Integer totalWeight;
    private Date receiptDate;
    private Date exportDate;
    private BigDecimal taxCost;

    private String transmitterFio;
    private Position transmitterPosition;

    private String acceptorFio;
    private Position acceptorPosition;

    private Stock stock;
    private Organization senderOrganization;
    private Organization receipentOrganization;
    private User manager;


    @Id
    @SequenceGenerator(name="waybill_generator", sequenceName="katstock.waybill_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waybill_generator")
    @Column(name = "waybill_id")
    public Long getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    @Column(name = "total_cost", nullable = false)
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Column(name = "total_weight", nullable = false)
    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Column(name = "receipt_date", nullable = false)
    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Column(name = "export_date", nullable = false)
    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    @Column(name = "tax_cost", nullable = false)
    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    @Column(name = "transmitter_fio", nullable = false, length = 20)
    public String getTransmitterFio() {
        return transmitterFio;
    }

    public void setTransmitterFio(String transmitterFio) {
        this.transmitterFio = transmitterFio;
    }

    @ManyToOne
    @JoinColumn(name = "transmitter_position_id", nullable = false)
    public Position getTransmitterPosition() {
        return transmitterPosition;
    }

    public void setTransmitterPosition(Position transmitterPosition) {
        this.transmitterPosition = transmitterPosition;
    }

    @Column(name = "acceptor_fio", nullable = false, length = 20)
    public String getAcceptorFio() {
        return acceptorFio;
    }

    public void setAcceptorFio(String acceptorFio) {
        this.acceptorFio = acceptorFio;
    }

    @ManyToOne
    @JoinColumn(name = "acceptor_position_id", nullable = false)
    public Position getAcceptorPosition() {
        return acceptorPosition;
    }

    public void setAcceptorPosition(Position acceptorPosition) {
        this.acceptorPosition = acceptorPosition;
    }

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @ManyToOne
    @JoinColumn(name = "sender_organization_id")
    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "receipent_organization_id")
    public Organization getReceipentOrganization() {
        return receipentOrganization;
    }

    public void setReceipentOrganization(Organization receipentOrganization) {
        this.receipentOrganization = receipentOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
