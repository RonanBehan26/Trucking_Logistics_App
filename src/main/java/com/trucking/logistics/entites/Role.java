package com.trucking.logistics.entites;

import javax.persistence.*;

@Entity(name = "RoleEntity") //overrides entity default name
@Table(name = "role")  //(overrides default table name) sets the name of the table being mapped by this entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
