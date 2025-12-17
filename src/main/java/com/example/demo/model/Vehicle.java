
package com.example.demo.model;

import java.security.Timestamp;

public class Vehicle {
    private long id;
    private String vin;
    private  String name;
    private String model;
    private int year;
    private long ownerid;
    private Boolean active;
    private Timestamp createdAt;
    public Vehicle(long id, String vin, String name, String model, int year, long ownerid, Boolean active,
            Timestamp createdAt) {
        this.id = id;
        this.vin = vin;
        this.name = name;
        this.model = model;
        this.year = year;
        this.ownerid = ownerid;
        this.active = active;
        this.createdAt = createdAt;
    }
    public Vehicle() {
    }
    public long getId() {
        return id;
    }
    public String getVin() {
        return vin;
    }
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public long getOwnerid() {
        return ownerid;
    }
    public Boolean getActive() {
        return active;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
     
    
}
package com.example.demo.model;

import java.security.Timestamp;

public class Vehicle {
    private long id;
    private String vin;
    private  String name;
    private String model;
    private int year;
    private long ownerid;
    private Boolean active;
    private Timestamp createdAt;
    public Vehicle(long id, String vin, String name, String model, int year, long ownerid, Boolean active,
            Timestamp createdAt) {
        this.id = id;
        this.vin = vin;
        this.name = name;
        this.model = model;
        this.year = year;
        this.ownerid = ownerid;
        this.active = active;
        this.createdAt = createdAt;
    }
    public Vehicle() {
    }
    public long getId() {
        return id;
    }
    public String getVin() {
        return vin;
    }
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public long getOwnerid() {
        return ownerid;
    }
    public Boolean getActive() {
        return active;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
     
    
}
package com.example.demo.model;

import java.security.Timestamp;
import java.sql.Date;

import org.hibernate.mapping.ManyToOne;

public class ServiceEntry {
    private long id;
    private  ManyToOne  vehicle;
    private ManyToOne  garage;
    private String serviceType;
    private Date serviceDate;
    private Integer odometerReading;
    private String description;
    private Timestamp recordedAt;
    
    public ServiceEntry(long id, ManyToOne vehicle, ManyToOne garage, String serviceType, Date serviceDate,
            Integer odometerReading, String description, Timestamp recordedAt) {
        this.id = id;
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
        this.recordedAt = recordedAt;
    }
    public ServiceEntry(){

    }
    public long getId() {
        return id;
    }
    public ManyToOne getVehicle() {
        return vehicle;
    }
    public ManyToOne getGarage() {
        return garage;
    }
    public String getServiceType() {
        return serviceType;
    }
    public Date getServiceDate() {
        return serviceDate;
    }
    public Integer getOdometerReading() {
        return odometerReading;
    }
    public String getDescription() {
        return description;
    }
    public Timestamp getRecordedAt() {
        return recordedAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setVehicle(ManyToOne vehicle) {
        this.vehicle = vehicle;
    }
    public void setGarage(ManyToOne garage) {
        this.garage = garage;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRecordedAt(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }
    
    
    
}
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
package com.example.demo.model;

public class User {
    private long id;
    private String email;
    private String password;
    private String role;
    public User(long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public User(){

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
     
}
