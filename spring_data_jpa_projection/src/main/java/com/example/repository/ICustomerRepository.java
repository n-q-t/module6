package com.example.repository;

import com.example.model.Customer;
import com.example.model.CustomerInfo;
import com.example.model.ICustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    List<CustomerInfo> findAllBy();

    @Modifying
    @Query("SELECT c.name AS name, COUNT(o.id) AS totalOrders FROM Customer c JOIN c.orders o GROUP BY c.id")
    List<ICustomerOrder> findAllByOrder();
}
