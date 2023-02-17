package com.example.repository;

import com.example.model.BenhAn;
import com.example.model.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBenhAnRepository extends JpaRepository<BenhAn,Integer> {
    @Query(value = "select * from benh_an",nativeQuery = true)
    List<BenhAn> getAll();
}
