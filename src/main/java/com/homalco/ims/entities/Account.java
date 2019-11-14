package com.homalco.ims.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String type;

  //  private List<Product> products;

 //   private List<Bundle> bundles;
}
