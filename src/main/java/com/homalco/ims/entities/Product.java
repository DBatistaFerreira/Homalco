package com.homalco.ims.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

  //  private List<Timestamp> timestamps;
}
