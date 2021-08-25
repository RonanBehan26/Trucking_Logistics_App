package com.trucking.logistics.entites;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pick_up_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date pickuptime;

    @Column(name = "vehicle_number")
    private Long vehicleNumber;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "material_type")
    private String materialType;

    @Column(name = "total_load")
    private Long totalLoad;

    @Column(name = "invoice_collected")
    private Boolean invoiceCollected;

    @Column(name = "statutory_docs_collected")
    private Boolean statutoryDocsCollected;

    @Column(name = "price")
    private Long price;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "status")
    private String status = "A";//this is the default status - A for active, otherwise it's I for Inactive

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getPickuptime() {
        return pickuptime;
    }

    public void setPickuptime(Date pickuptime) {
        this.pickuptime = pickuptime;
    }

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Long getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(Long totalLoad) {
        this.totalLoad = totalLoad;
    }

    public Boolean isInvoiceCollected() {
        return invoiceCollected;
    }

    public void setInvoiceCollected(Boolean invoiceCollected) {
        this.invoiceCollected = invoiceCollected;
    }

    public Boolean isStatutoryDocsCollected() {
        return statutoryDocsCollected;
    }

    public void setStatutoryDocsCollected(Boolean statutoryDocsCollected) {
        this.statutoryDocsCollected = statutoryDocsCollected;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean isPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
         this.paid = paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(!status.equals("A")){//this is the default status - A for active, otherwise you must set I for Inactive
            this.status = "I";
        }
        else {
            this.status = status;
        }
    }
}
