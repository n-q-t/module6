package com.example.service.impl;

import com.example.model.IOrderCustomer;
import com.example.model.Orders;
import com.example.repository.IOrderRepository;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public List<Orders> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public List<IOrderCustomer> findAllBy() {
        return iOrderRepository.findAllBy();
    }
}
