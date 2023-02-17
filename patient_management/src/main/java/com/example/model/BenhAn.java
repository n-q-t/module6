package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenhAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ten;
    @OneToMany(mappedBy = "benhAn")
    @JsonBackReference
    private Set<BenhNhan> benhNhans;
    public BenhAn(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public BenhAn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
