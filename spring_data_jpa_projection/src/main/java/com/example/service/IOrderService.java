package com.example.service;

import com.example.model.IOrderCustomer;
import com.example.model.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll();

    List<IOrderCustomer> findAllBy();
}
