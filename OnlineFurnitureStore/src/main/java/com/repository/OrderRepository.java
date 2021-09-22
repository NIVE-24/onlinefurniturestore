package com.repository;

import com.entity.Order;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,String> {
    List<Order> findAll();
//    @Modifying
//    @Query("update CUSTOMER_ORDER co set co.status = :status where co.customer = :id")
//    int setStatusToPaid(@Param("status") String status,@Param("id") int id);
//    setSta
    
}
