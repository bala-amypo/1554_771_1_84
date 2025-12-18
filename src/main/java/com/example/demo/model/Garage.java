 package com.example.demo.model;

public class Garage {
    private long id;
    private String garageName;
    private String address;
    private String contactNumber;
    private Boolean active;
    
    public Garage(long id, String garageName, String address, String contactNumber, Boolean active) {
        this.id = id;
        this.garageName = garageName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.active = active;
    }
    public Garage(){

    }
    public long getId() {
        return id;
    }
    public String getGarageName() {
        return garageName;
    }
    public String getAddress() {
        return address;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive() {
        return active;
    }
    
    
}
                                                                                                                                    