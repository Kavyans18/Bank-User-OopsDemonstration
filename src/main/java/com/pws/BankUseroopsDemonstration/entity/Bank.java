package com.pws.BankUseroopsDemonstration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "bank")
public class Bank {

    @Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bank_name", nullable = false, unique = true)
    private String name;
    @Column(name = "bank_email", nullable = false)
    private String email;
    @Column(name = "bank_address", nullable = false)
    private String address;
    @Column(name = "bank_phone_number", nullable = false)
    private long phoneNumber;
    @OneToMany(mappedBy = "bank" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<User> user;
}
