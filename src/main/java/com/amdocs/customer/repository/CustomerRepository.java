package com.amdocs.customer.repository;

import com.amdocs.customer.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository  extends CrudRepository < Customer, Integer> {
}
