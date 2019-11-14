package com.homalco.ims.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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
