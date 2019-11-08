package com.homalco.ims.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BUNDLE")
public class Bundle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String category;

    @Column
    private String information;

   // private List<Product> products;

   // private List<Timestamp> timestamps;
}
