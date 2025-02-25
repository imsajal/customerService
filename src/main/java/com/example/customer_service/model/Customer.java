package com.example.customer_service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer") // this is required only if table name is different
@Getter
@Setter
public class Customer {

    // id should be long
    @Id // marks primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // relies on sequential autoincrement feature of
    // mysql
    private Long customerId;

    //   @Enumerated(EnumType.STRING)
    // enum fields

    //@Column(name = "full_name") // Maps 'name' field to 'full_name' column in DB
    //private String name;
}
