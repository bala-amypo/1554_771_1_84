package com.example.demo.model;

import java.math.BigDecimal;

import org.hibernate.mapping.ManyToOne;

public class ServicePart {
    private long id;
    private ManyToOne serviceEntry;
    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private int quantity;
    public ServicePart(long id, ManyToOne serviceEntry, String partName, String partNumber, BigDecimal cost,
            int quantity) {
        this.id = id;
        this.serviceEntry = serviceEntry;
        this.partName = partName;
        this.partNumber = partNumber;
        this.cost = cost;
        this.quantity = quantity;
    }
    public long getId() {
        return id;
    }
    public ManyToOne getServiceEntry() {
        return serviceEntry;
    }
    public String getPartName() {
        return partName;
    }
    public String getPartNumber() {
        return partNumber;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public int getQuantity() {
        return quantity;
    }
    public ServicePart(){

    }
    public void setId(long id) {
        this.id = id;
    }
    public void setServiceEntry(ManyToOne serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
    public void setPartName(String partName) {
        this.partName = partName;
    }
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}