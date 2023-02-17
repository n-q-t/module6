package com.example.repository;

import com.example.model.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBenhNhanRepository extends JpaRepository<BenhNhan, Integer> {

    @Modifying
    @Query(value = "select * from benh_nhan where delete_flag=false", nativeQuery = true)
    List<BenhNhan> getAll();

    @Modifying
    @Query(value = "INSERT INTO patient.benh_nhan (bac_si,delete_flag,ly_do,ngay_nhap_vien,ngay_ra_vien,phuong_phap,ten,benh_an_id) VALUES (:bacSi,0,:lyDo,:ngayNhapVien,:ngayRaVien,:phuongPhap,:ten,:benhAnId);", nativeQuery = true)
    void save(@Param("bacSi") String bacSi,@Param("lyDo") String lyDo,@Param("ngayNhapVien") String ngayNhapVien,@Param("ngayRaVien") String ngayRaVien, @Param("phuongPhap") String phuongPhap, @Param("ten") String ten,@Param("benhAnId") int benhAnId);

    @Modifying
    @Query(value = "select * from benh_nhan where delete_flag=false and id=:id",nativeQuery = true)
    BenhNhan findById(@Param("id")int id);

    @Modifying
    @Query(value = "UPDATE `patient`.`benh_nhan` SET `delete_flag` = 1 WHERE (`id` = :id);",nativeQuery = true)
    void delete(@Param("id")int id);

    @Modifying
    @Query(value = "UPDATE `patient`.`benh_nhan` SET bac_si=:bacSi,ly_do=:lyDo,ngay_nhap_vien=:ngayNhapVien,ngay_ra_vien=: ngayRaVien,phuong_phap=:phuongPhap,ten=:ten,benh_an_id=:benhAnId WHERE (`id` = :id);",nativeQuery = true)
    void update(@Param("bacSi")String bacSi,@Param("lyDo") String lyDo,@Param("ngayNhapVien") String ngayNhapVien,@Param("ngayRaVien") String ngayRaVien,@Param("phuongPhap") String phuongPhap, @Param("ten") String ten,@Param("benhAnId") int benhAnId,@Param("id") int id);
}
