package com.amdocs.customer.services;


import com.amdocs.customer.entities.Customer;
import com.amdocs.customer.exception.CustomerException;
import com.amdocs.customer.repository.CustomerRepository;
import com.amdocs.customer.request.CustomerRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }


    public void addCustomer(CustomerRequest customerRequest) {
        Customer  customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setAddress(customerRequest.getAddress());
        customer.setCreationDate(LocalDate.now());

        customerRepository.save(customer);

    }





    public Optional<Customer> getCustomerById(Integer customerID) {
        Optional<Customer> customer = customerRepository.findById(customerID);

//        if (customer.isEmpty()) {
//            throw new EntityNotFoundException("The customer ID no exist");
//        }

        return customer;
    }





}
