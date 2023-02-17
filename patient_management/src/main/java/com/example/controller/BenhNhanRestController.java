package com.example.controller;

import com.example.model.BenhNhan;
import com.example.service.IBenhAnService;
import com.example.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("benhnhan")
@CrossOrigin("*")
public class BenhNhanRestController {
    @Autowired
    private IBenhNhanService iBenhNhanService;
    @Autowired
    private IBenhAnService iBenhAnService;

    @GetMapping(value = "")
    public ResponseEntity<List<BenhNhan>> getList() {
        List<BenhNhan> benhNhanList = iBenhNhanService.getAll();
        if (benhNhanList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhNhanList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> save(@RequestBody BenhNhan benhNhan) {
        System.out.println(benhNhan.getId());
        benhNhan.setBenhAn(iBenhAnService.findById(benhNhan.getBenhAn().getId()).get());
        iBenhNhanService.save(benhNhan.getBacSi(), benhNhan.getLyDo(), benhNhan.getNgayNhapVien(), benhNhan.getNgayRaVien(), benhNhan.getPhuongPhap(), benhNhan.getTen(), benhNhan.getBenhAn().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody BenhNhan benhNhan, @PathVariable("id") int id) {
        BenhNhan benhNhan1 = iBenhNhanService.findById(id);
        if (benhNhan1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBenhNhanService.update(benhNhan.getBacSi(), benhNhan.getLyDo(), benhNhan.getNgayNhapVien(), benhNhan.getNgayRaVien(), benhNhan.getPhuongPhap(), benhNhan.getTen(), benhNhan.getBenhAn().getId(), benhNhan.getId());
        return new ResponseEntity<>(benhNhan, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        BenhNhan benhNhan = iBenhNhanService.findById(id);
        if (benhNhan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBenhNhanService.delete(id);
        return new ResponseEntity<>(benhNhan, HttpStatus.OK);
    }
}
