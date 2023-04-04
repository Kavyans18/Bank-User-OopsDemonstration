package com.pws.BankUseroopsDemonstration.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "user_phone_number", nullable = false, unique = true)
    private long phoneNumber;
    @Column(name = "user_account_number", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "user_address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    Bank bank;
}