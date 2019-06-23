package demo.yanming.springboot.jpa.service.impl;

import demo.yanming.springboot.jpa.entity.Student;
import demo.yanming.springboot.jpa.repository.StudentRepository;
import demo.yanming.springboot.jpa.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_jpa_demo <br/>
 * Package Name:demo.yanming.springboot.jpa.service.impl <br/>
 * Date:2019/2/19 21:43 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 保存学生信息
     * @param student
     * @return
     */
    
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * 根据 Id 查询学生信息
     * @param id
     * @return
     */
    
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    /**
     * 删除学生信息
     * @param id
     */
    
    public void delete(Integer id) {
        Student student = this.findStudentById(id);
        studentRepository.delete(student);
    }

    /**
     * 更新学生信息
     * @param student
     */
    
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    /**
     * 查询学生信息列表
     * @return
     */
    
    public List<Student> findStudentList() {
        return studentRepository.findAll();
    }
}
