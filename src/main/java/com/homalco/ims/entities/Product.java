package com.homalco.ims.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MARKET_PRICE")
    private double marketPrice;

    @Column(name = "ACTIVATED")
    private boolean activated;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Timestamp> timestamps;
}
