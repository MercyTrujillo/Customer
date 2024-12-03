package com.amdocs.customer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement ID]
//    @Column(name = "customerId")
//    private int customerID;

    private String name;

    private String lastName;

//    private String address;
    @Id
    private String email;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +

                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
             //", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public Customer(String name, String lastName,String email, LocalDate creationDate) {

        this.name = name;
        this.lastName = lastName;
       //this.address = address;
        this.email = email;
        this.creationDate = creationDate;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
