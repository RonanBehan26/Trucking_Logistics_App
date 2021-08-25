package com.trucking.logistics.entites;

import javax.persistence.*;

@Entity(name = "Contact")
@Table(name = "contact")
public class Contact {

    @Id
    private Long id = Long.valueOf(1);

    @Column(name = "email")
    private String email = "ronanLogisitics@gmail.com";

    @Column(name = "phone_number")
    private String phoneNumber = "083-4556777";

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
