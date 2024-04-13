package com.robotdreams.assignment11.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User extends BaseEntity implements Serializable {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean premium;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders;
}
