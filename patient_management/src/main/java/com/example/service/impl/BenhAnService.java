package com.example.service.impl;

import com.example.model.BenhAn;
import com.example.repository.IBenhAnRepository;
import com.example.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenhAnService implements IBenhAnService {
    @Autowired
    private IBenhAnRepository iBenhAnRepository;
    @Override
    public List<BenhAn> getAll() {
        return iBenhAnRepository.getAll();
    }

    @Override
    public Optional<BenhAn> findById(int id) {
        return iBenhAnRepository.findById(id);
    }
}
