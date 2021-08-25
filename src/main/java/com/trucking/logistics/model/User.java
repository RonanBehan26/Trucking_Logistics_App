package com.trucking.logistics.model;

import com.trucking.logistics.entites.Trips;
import org.springframework.stereotype.Component;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Component
@Table(name="user")
public class User {

    private String clientId;
    private String role;

    @OneToMany(mappedBy="user")//mappedBy element to indicate the entity that owns the bidirectional relationship.
    private Set<Trips> trips;

    public User() {
    }

    public User(String clientId, String role) {
        this.clientId = clientId;
        this.role = role;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "clientId='" + clientId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}