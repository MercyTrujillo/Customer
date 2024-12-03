package com.amdocs.customer.request;

public class CustomerRequest {

    private String name;

    private String lastName;

    private String email;

//    private String address;

    public CustomerRequest(String name, String lastName,String email) {
        this.name = name;
        this.lastName = lastName;
//        this.address = address;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
