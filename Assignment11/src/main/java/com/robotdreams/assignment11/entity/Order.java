package com.robotdreams.assignment11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Table(name = "Orders")
@Entity
@Getter
@Setter
public class Order extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OrderProduct> orderProducts;

    private String orderNumber;

    private String description;

    private double shippingCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
