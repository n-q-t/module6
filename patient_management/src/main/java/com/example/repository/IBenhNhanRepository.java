package com.example.repository;

import com.example.model.BenhNhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBenhNhanRepository extends JpaRepository<BenhNhan, Integer> {

    @Query(value = "select * from patient.benh_nhan where delete_flag=false and id = :idBenhNhan",nativeQuery = true)
    BenhNhan findById(@Param("idBenhNhan") int id);

    @Query(value = "select * from patient.benh_nhan where delete_flag=false", nativeQuery = true)
    List<BenhNhan> getAll();

    @Query(value = "select * from patient.benh_nhan where delete_flag=false", nativeQuery = true)
    Page<BenhNhan> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO patient.benh_nhan (id,bac_si,ly_do,ngay_nhap_vien,ngay_ra_vien, phuong_phap, ten, benh_an_id) VALUES (0,:bacSi,:lyDo,:ngayNhapVien,:ngayRaVien,:phuongPhap,:tenBenhNhan,:benhAnId);", nativeQuery = true)
    void save(@Param("bacSi") String bacSi,@Param("lyDo") String lyDo,@Param("ngayNhapVien") String ngayNhapVien,@Param("ngayRaVien") String ngayRaVien, @Param("phuongPhap") String phuongPhap, @Param("tenBenhNhan") String ten,@Param("benhAnId") int benhAnId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `patient`.`benh_nhan` SET `delete_flag` = 1 WHERE (`id` = :id);",nativeQuery = true)
    void delete(@Param("id")int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `patient`.`benh_nhan` SET bac_si = :bacSi,ly_do = :lyDo,ngay_nhap_vien = :ngayNhapVien,ngay_ra_vien = :ngayRaVien,phuong_phap = :phuongPhap,ten = :ten,benh_an_id = :benhAnId WHERE (`id` = :idBenhNhan);",nativeQuery = true)
    void update(@Param("bacSi")String bacSi,@Param("lyDo") String lyDo,@Param("ngayNhapVien") String ngayNhapVien,@Param("ngayRaVien") String ngayRaVien,@Param("phuongPhap") String phuongPhap, @Param("ten") String ten,@Param("benhAnId") int benhAnId,@Param("idBenhNhan") int id);


    @Query(value = "select * from patient.benh_nhan where delete_flag=false and bac_si like concat('%',:bacSi,'%') and ten like concat('%',:ten,'%') ", nativeQuery = true)
    Page<BenhNhan> getListBySearch(Pageable pageable,@Param("ten") String ten,@Param("bacSi") String bacSi);
}
