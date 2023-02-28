package com.c0822g1primaryschoolbe.controller;

import com.c0822g1primaryschoolbe.entity.clazz.IClazzName;
import com.c0822g1primaryschoolbe.entity.clazz.IClazzTeacher;
import com.c0822g1primaryschoolbe.entity.clazz.IClazzYear;
import com.c0822g1primaryschoolbe.entity.student.IStudentInfo;
import com.c0822g1primaryschoolbe.entity.student.Student;
import com.c0822g1primaryschoolbe.entity.teacher.ITeacherInfo;
import com.c0822g1primaryschoolbe.service.IClazzService;
import com.c0822g1primaryschoolbe.service.IStudentService;
import com.c0822g1primaryschoolbe.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin("*")
public class StudentRestController {

    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IClazzService iClazzService;
    @Autowired
    private ITeacherService iTeacherService;


    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get List Student by Param
     *
     * @param year,clazzId
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
//    @GetMapping("/student-list")
//    public ResponseEntity<Page<IStudentInfo>> getStudentList(@PageableDefault(size =10) Pageable pageable, @RequestParam String year, @RequestParam String clazzId){
//        Page<IStudentInfo> iStudentInfos=iStudentService.getStudentList(pageable,Integer.parseInt(year),Integer.parseInt(clazzId));
//        if (iStudentInfos.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(iStudentInfos,HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<List<IStudentInfo>> getStudentList(@RequestParam String year, @RequestParam String clazzId) {
        List<IStudentInfo> iStudentInfos = iStudentService.getStudentList(Integer.parseInt(year), Long.parseLong(clazzId));
        if (iStudentInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iStudentInfos, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get List Year
     *
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/year")
    public ResponseEntity<List<IClazzYear>> getListYear() {
        List<IClazzYear> iClazzYears = iClazzService.getListYear();
        if (iClazzYears.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzYears, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get List Clazz Name by Param
     *
     * @param year,name
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping()
    public ResponseEntity<List<IClazzName>> getListClazzName(@RequestParam("year") String year, @RequestParam("name") String name) {
        List<IClazzName> iClazzNames = iClazzService.getListClazzName(Integer.parseInt(year), name);
        if (iClazzNames.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzNames, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get info Clazz and Teacher by Param
     *
     * @param year,clazzId
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/clazz")
    public ResponseEntity<IClazzTeacher> getClazzTeacher(@RequestParam String year, @RequestParam String clazzId) {
        IClazzTeacher iClazzTeacher = iClazzService.getClazzTeacher(Integer.parseInt(year), Long.parseLong(clazzId));
        if (iClazzTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iClazzTeacher, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get list teacher name by Param
     *
     * @param year
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/teacher-name-list")
    public ResponseEntity<List<ITeacherInfo>> getListNameTeacher(@RequestParam String year) {
        List<ITeacherInfo> iTeacherInfos = iTeacherService.getListNameTeacher(Integer.parseInt(year));
        if (iTeacherInfos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iTeacherInfos, HttpStatus.OK);
    }

    /**
     * Create by:TrungNQ
     * Date create:27/2/2023
     * Funciton: get teacher name by Param
     *
     * @param year,name
     * @return HttpStatus.NO_CONTENT if rerult is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/teacher-name")
    public ResponseEntity<ITeacherInfo> getNameTeacher(@RequestParam String idCard, @RequestParam String year) {
        ITeacherInfo iTeacherInfo = iTeacherService.getNameTeacher(idCard, Integer.parseInt(year));
        if (iTeacherInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iTeacherInfo, HttpStatus.OK);
    }

    @GetMapping("/edit-teacher")
    public void editTeacher(@RequestParam String teacherId, @RequestParam String clazzId) {
        iClazzService.editTeacher(Long.parseLong(teacherId), Long.parseLong(clazzId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        Student student=iStudentService.findStudentById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iStudentService.deleteStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

}
