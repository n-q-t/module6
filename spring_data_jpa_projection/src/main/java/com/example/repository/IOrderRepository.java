package com.example.repository;

import com.example.model.IOrderCustomer;
import com.example.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Orders,Integer> {
    List<IOrderCustomer> findAllBy();
}
