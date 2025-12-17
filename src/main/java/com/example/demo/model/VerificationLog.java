package com.example.demo.model;

import java.security.Timestamp;

import org.hibernate.mapping.ManyToOne;

public class VerificationLog {
    private long id;
    private ManyToOne serviceEntry;
    private Timestamp verifiedAt;
    private Boolean verifiedBySystem;
    private String notes;

     public VerificationLog(long id, ManyToOne serviceEntry, Timestamp verifiedAt, Boolean verifiedBySystem,
            String notes) {
        this.id = id;
        this.serviceEntry = serviceEntry;
        this.verifiedAt = verifiedAt;
        this.verifiedBySystem = verifiedBySystem;
        this.notes = notes;
    }
    public VerificationLog(){

    }
    public long getId() {
        return id;
    }
    public ManyToOne getServiceEntry() {
        return serviceEntry;
    }
    public Timestamp getVerifiedAt() {
        return verifiedAt;
    }
    public Boolean getVerifiedBySystem() {
        return verifiedBySystem;
    }
    public String getNotes() {
        return notes;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setServiceEntry(ManyToOne serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
    public void setVerifiedAt(Timestamp verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
    public void setVerifiedBySystem(Boolean verifiedBySystem) {
        this.verifiedBySystem = verifiedBySystem;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
     
    
}