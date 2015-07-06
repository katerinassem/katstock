package by.itechart.katstock.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by katsiaryna.siamikina on 02.07.2015.
 */
public class Waybill extends Entity {

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


    public Long getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public BigDecimal getTaxCost() {
        return taxCost;
    }

    public void setTaxCost(BigDecimal taxCost) {
        this.taxCost = taxCost;
    }

    public String getTransmitterFio() {
        return transmitterFio;
    }

    public void setTransmitterFio(String transmitterFio) {
        this.transmitterFio = transmitterFio;
    }

    public Position getTransmitterPosition() {
        return transmitterPosition;
    }

    public void setTransmitterPosition(Position transmitterPosition) {
        this.transmitterPosition = transmitterPosition;
    }

    public String getAcceptorFio() {
        return acceptorFio;
    }

    public void setAcceptorFio(String acceptorFio) {
        this.acceptorFio = acceptorFio;
    }

    public Position getAcceptorPosition() {
        return acceptorPosition;
    }

    public void setAcceptorPosition(Position acceptorPosition) {
        this.acceptorPosition = acceptorPosition;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    public Organization getReceipentOrganization() {
        return receipentOrganization;
    }

    public void setReceipentOrganization(Organization receipentOrganization) {
        this.receipentOrganization = receipentOrganization;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
