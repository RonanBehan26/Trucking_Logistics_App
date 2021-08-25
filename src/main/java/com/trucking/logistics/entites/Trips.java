package com.trucking.logistics.entites;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Trips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne //this is only unidirectional at the moment as I have left out corresponding properties in the trips class
    @JoinColumn(name="user_id", nullable=false, insertable = false, updatable = false)
    //The child entity, that has the join column, is called the owner of the relationship defined using the @ManyToOne annotation.
//    The @JoinColumn annotation is used to specify the foreign key column in the owner of the relationship.
//    The inverse-side of the relationship sets the mappedBy attribute to indicate that the relationship is owned by the other entity.
     private User user;

    @Column(name = "trip_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date tripTime;

    @Column(name = "pick_up_from")
    private String pickUpFrom;

    @Column(name = "drop_to")
    private String dropTo;

    @Column(name = "driver_name")
    private String driverName;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "vehicle_number")
    private Long vehicleNumber;

    @Column(name = "driver_phone_number")
    private String driverPhoneNumber;

    public Trips() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTripTime() {
        return tripTime;
    }

    public void setTripTime(Date tripTime) {
        this.tripTime = tripTime;
    }

    public String getPickUpFrom() {
        return pickUpFrom;
    }

    public void setPickUpFrom(String pickUpFrom) {
        this.pickUpFrom = pickUpFrom;
    }

    public String getDropTo() {
        return dropTo;
    }

    public void setDropTo(String dropTo) {
        this.dropTo = dropTo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Long vehicle_number) {
        this.vehicleNumber = vehicle_number;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }
}
