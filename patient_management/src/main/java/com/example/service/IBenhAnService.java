package com.example.service;

import com.example.model.BenhAn;

import java.util.List;
import java.util.Optional;

public interface IBenhAnService {
    List<BenhAn> getAll();
    Optional<BenhAn> findById(int id);
}
