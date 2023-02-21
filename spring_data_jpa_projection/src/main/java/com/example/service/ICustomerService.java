package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerInfo;
import com.example.model.ICustomerOrder;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    List<CustomerInfo> findAllBy();

    List<ICustomerOrder> findAllByOrder();
}
