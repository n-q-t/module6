package com.example.controller;

import com.example.model.BenhAn;
import com.example.model.BenhNhan;
import com.example.service.IBenhAnService;
import com.example.service.impl.BenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("benhan")
@CrossOrigin("*")
public class BenhAnRestController {
    @Autowired
    private IBenhAnService ibenhAnService;
    @GetMapping(value = "")
    public ResponseEntity<List<BenhAn>> getList() {
        List<BenhAn> benhAnList = ibenhAnService.getAll();
        if (benhAnList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
    }
}
