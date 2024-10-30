package com.amit.BankingAppWithRest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//for autometically creating getter setter meathod for Account class
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//making this class as jpa entity
@Entity
//configuring table details using table annotation, giving table name
@Table(name = "accounts")
public class Account {
    //to make id as primary key in database
    @Id
    //To auto increment primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //To give column name
    @Column(name = "account_holder_name")
    private String accountHolderName;

    private double balance;
}
