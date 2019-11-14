package com.homalco.ims.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BUNDLE")
public class Bundle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;

    @Column
    private String information;

   // private List<Product> products;

   // private List<Timestamp> timestamps;
}
