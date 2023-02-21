package com.example.service.impl;

import com.example.model.Customer;
import com.example.model.CustomerInfo;
import com.example.model.ICustomerOrder;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public List<CustomerInfo> findAllBy() {
        return iCustomerRepository.findAllBy();
    }

    @Override
    public List<ICustomerOrder> findAllByOrder() {
        return iCustomerRepository.findAllByOrder();
    }
}
