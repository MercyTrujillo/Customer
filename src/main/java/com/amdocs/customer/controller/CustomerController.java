package com.amdocs.customer.controller;

import com.amdocs.customer.entities.Customer;
import com.amdocs.customer.request.CustomerRequest;
import com.amdocs.customer.response.CustomerResponse;
import com.amdocs.customer.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();

    }


    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerRequest customerRequest){
            customerService.addCustomer(customerRequest);
            String message = "Customer added!!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }



    @RequestMapping(method = RequestMethod.GET,value = "/customer/{email}")
    public Optional<Customer> getCustomerById(@PathVariable String email){
        Optional<Customer> customer = customerService.getCustomerById(email);
            return customerService.getCustomerById(email);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/customer/{email}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String email, @RequestBody  CustomerRequest customerRequest){
        Customer customer = customerService.updateCustomer(email, customerRequest);
        return ResponseEntity.ok(customer);
    }


    @DeleteMapping(value ="/customer/{email}" )
    public ResponseEntity<String> deleteCustomer(@PathVariable String email){
        customerService.deleteCustomer(email);

        return ResponseEntity.ok("customer deleted");
    }





}
