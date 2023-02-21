package com.example.controller;

import com.example.model.BenhNhan;
import com.example.service.IBenhAnService;
import com.example.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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


//
//    @GetMapping
//    public Page<BenhNhan> getList(@PageableDefault(size =5) Pageable pageable) {
//        return iBenhNhanService.findAll(pageable);
//    }

    @GetMapping
    public Page<BenhNhan> getListBySearch(@PageableDefault(page = 0,size =5) Pageable pageable,@RequestParam(defaultValue = "") String ten,@RequestParam(defaultValue = "") String bacSi) {
        return iBenhNhanService.getListBySearch(pageable,ten,bacSi);
    }


//    @GetMapping
//    public List<BenhNhan> getList() {
//        List<BenhNhan> benhNhanList = iBenhNhanService.getAll();
//        return benhNhanList;
//    }

    @PostMapping
    public BenhNhan save(@RequestBody BenhNhan benhNhan) {
        iBenhNhanService.save(benhNhan.getBacSi(), benhNhan.getLyDo(), benhNhan.getNgayNhapVien(), benhNhan.getNgayRaVien(), benhNhan.getPhuongPhap(), benhNhan.getTen(), benhNhan.getBenhAn().getId());
        return benhNhan;
    }

    @GetMapping("/{id}")
    private BenhNhan findById(@PathVariable int id) {
        BenhNhan benhNhan = iBenhNhanService.findById(id);
        return benhNhan;
    }


    @PatchMapping("/{id}")
    public BenhNhan update(@RequestBody BenhNhan benhNhan, @PathVariable("id") int id) {
        BenhNhan benhNhan1 = iBenhNhanService.findById(id);
        if (benhNhan1 == null) {
            return null;
        }
        iBenhNhanService.update(benhNhan.getBacSi(), benhNhan.getLyDo(), benhNhan.getNgayNhapVien(), benhNhan.getNgayRaVien(), benhNhan.getPhuongPhap(), benhNhan.getTen(), benhNhan.getBenhAn().getId(), id);
        return benhNhan;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        BenhNhan benhNhan = iBenhNhanService.findById(id);
        iBenhNhanService.delete(id);
    }


}

