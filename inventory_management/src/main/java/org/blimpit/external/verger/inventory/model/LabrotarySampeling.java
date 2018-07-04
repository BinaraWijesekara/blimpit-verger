package org.blimpit.external.verger.inventory.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LabrotarySampeling {
    private String date;
    private String customer;
    private String product;
    private String type;
    private int sampleSize;
    private String ifLot;
    private String lotNumber;
    private String sampleNumber;
    private String formulation;
    private String status;
    private String comment;
    private String shipmentDate;
    private String documents;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getIfLot() {
        return ifLot;
    }

    public void setIfLot(String ifLot) {
        this.ifLot = ifLot;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }
}
