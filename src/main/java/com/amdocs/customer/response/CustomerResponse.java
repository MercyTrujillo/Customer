package com.amdocs.customer.response;

import com.amdocs.customer.entities.Customer;

public class CustomerResponse {
    private Integer customerID;

    private String name;

    private String lastName;

    private String email;

//    private String address;

    public CustomerResponse(Integer customerID, String name, String lastName, String email) {
        this.customerID = customerID;
        this.name = name;
        this.lastName = lastName;
//        this.address = address;
        this.email = email;
    }

    public CustomerResponse(Customer customer) {
    }

    public Integer getCustomerID() { return customerID;}

    public void setCustomerID(Integer customerID){this.customerID = customerID;}

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
}
