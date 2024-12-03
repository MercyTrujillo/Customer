package com.amdocs.customer.services;


import com.amdocs.customer.entities.Customer;
import com.amdocs.customer.exception.CustomerException;
import com.amdocs.customer.repository.CustomerRepository;
import com.amdocs.customer.request.CustomerRequest;
import com.amdocs.customer.response.CustomerResponse;
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
        //customer.setAddress(customerRequest.getAddress());

        customer.setEmail(customerRequest.getEmail());
        customer.setCreationDate(LocalDate.now());
        customerRepository.save(customer);

    }





    public Optional<Customer> getCustomerById(String email) {
        Optional<Customer> customer = customerRepository.findById(email);
        System.out.println(email);
        return customer;
    }


    public Customer updateCustomer(String email, CustomerRequest customerRequest) {
            Optional<Customer> optionalCustomer= customerRepository.findById(email);
            if(optionalCustomer.isPresent()){
                Customer customer = optionalCustomer.get();
                customer.setName(customerRequest.getName());
                customer.setLastName(customerRequest.getLastName());
                customer.setEmail(customerRequest.getEmail());
//                customer.setAddress(customerRequest.getAddress());
                customer.setCreationDate(LocalDate.now());
                return
                        customerRepository.save(customer);
            }else {
                optionalCustomer.orElseThrow(() -> new EntityNotFoundException("Customer not found"));
            }
            return null;

    }


    public void deleteCustomer(String email) {
        System.out.println("Customer Deleted");
        customerRepository.deleteById(email);

    }
}
