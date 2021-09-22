package com.repository;

import com.entity.Bill;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
    Bill findById(long billNo);
    List<Bill> findAll();
    @Query(nativeQuery = true, value = "SELECT b.bill_no AS billNo,* FROM BILL b WHERE b.customer_name = :customerName")
    Bill findByCustomer(@Param("customerName") String customerName);
}
