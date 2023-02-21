package com.example.controller;

import com.example.model.Customer;
import com.example.model.CustomerInfo;
import com.example.model.ICustomerOrder;
import com.example.model.Orders;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;
    @RequestMapping("customer")
    public ResponseEntity<List<Customer>> getList() {
        List<Customer> customerList = iCustomerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @RequestMapping("customer-info")
    public ResponseEntity<List<CustomerInfo>> getListCutomerInfo() {
        List<CustomerInfo> customerInfoList = iCustomerService.findAllBy();
        if (customerInfoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerInfoList, HttpStatus.OK);
    }

    @RequestMapping("customer-order")
    public ResponseEntity<List<ICustomerOrder>> getListTotalOrders() {
        List<ICustomerOrder> customerOrders = iCustomerService.findAllByOrder();
        if (customerOrders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }
}
