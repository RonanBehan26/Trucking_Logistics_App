package com.trucking.logistics.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Long roleId;

    @OneToMany(mappedBy="user")
    private Set<Trips> trips;

    //leaving this out but if you wanted all the trip info (bidirectional relationship) with the user info, leave it in
//    public Set<Trips> getTrips() {
//        return trips;
//    }
//    public void setTrips(Set<Trips> trips) {
//        this.trips = trips;
//    }
//
//    public Set<Trips> getTrips() {
//        return trips;
//    }

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.password = passWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
