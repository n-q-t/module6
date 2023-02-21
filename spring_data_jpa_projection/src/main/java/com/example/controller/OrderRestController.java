package com.example.controller;

import com.example.model.IOrderCustomer;
import com.example.model.Orders;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderRestController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("order")
    public ResponseEntity<List<Orders>> getList() {
        List<Orders> ordersList = iOrderService.findAll();
        if (ordersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("order-customer")
    public ResponseEntity<List<IOrderCustomer>> getListByOrderCustomer() {
        List<IOrderCustomer> orderCustomerInfos = iOrderService.findAllBy();
        if (orderCustomerInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderCustomerInfos, HttpStatus.OK);
    }

}
