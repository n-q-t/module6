package com.example.model.teacher;

import com.example.model.teacher.Degree;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeacher;
    private String nameTeacher;
    private String dateOfBirth;
    private String gender;
    @ManyToOne
    private Degree degree;
    private String teacherType;
    private String phoneNumber;
    @Column(columnDefinition ="bit default 1" )
    private boolean delete_flag=true;
    private boolean statusTeacher;

    public Teacher() {
    }

    public Teacher(int idTeacher, String nameTeacher, String dateOfBirth, String gender, Degree degree, String teacherType, String phoneNumber, boolean delete_flag, boolean statusTeacher) {
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.degree = degree;
        this.teacherType = teacherType;
        this.phoneNumber = phoneNumber;
        this.delete_flag = delete_flag;
        this.statusTeacher = statusTeacher;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(boolean delete_flag) {
        this.delete_flag = delete_flag;
    }

    public boolean isStatusTeacher() {
        return statusTeacher;
    }

    public void setStatusTeacher(boolean statusTeacher) {
        this.statusTeacher = statusTeacher;
    }
}
