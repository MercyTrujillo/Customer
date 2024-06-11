package com.amdocs.customer.controller;

import com.amdocs.customer.entities.Customer;
import com.amdocs.customer.request.CustomerRequest;
import com.amdocs.customer.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

// read interfaces funcionales
    @RequestMapping(method = RequestMethod.GET,value = "/customer/{customerID}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Integer customerID){

        Optional<Customer> customer = customerService.getCustomerById(customerID);
//        if(customerService.getCustomerById(customerID).isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND);
//        }else {
//            return ResponseEntity.getCustomerById(customerID);
//        }

//        new ResponseEntity<>()
        if(customer.isEmpty()){
            return (ResponseEntity<Optional<Customer>>) ResponseEntity.notFound();
        }
        Customer Customer= new Customer();
        return ResponseEntity.status(HttpStatus.OK).body(customer);

//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

 //return customerService.getCustomerById(customerID);



    }




}
