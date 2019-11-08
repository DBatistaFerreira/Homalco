package com.homalco.ims.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TIMESTAMP")
public class Timestamp {

    @Id
    @Column(name = "TIMESTAMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED_BY_ID")
    private long createdById;

    @Column(name = "TIME")
    private LocalDateTime time;
}
