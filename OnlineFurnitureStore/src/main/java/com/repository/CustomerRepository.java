package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    List<Customer> findAll();
    Customer findByEmail(String email);
}
