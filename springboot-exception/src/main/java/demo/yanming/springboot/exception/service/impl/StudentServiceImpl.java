package demo.yanming.springboot.exception.service.impl;

import demo.yanming.springboot.exception.bean.Student;
import demo.yanming.springboot.exception.dao.StudentRepository;
import demo.yanming.springboot.exception.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project Name:springboot_exception_demo <br/>
 * Package Name:demo.yanming.springboot.exception.service.impl <br/>
 * Date:2019/3/2 22:11 <br/>
 * <b>Description:</b> TODO: service 主要逻辑写在这里 <br/>
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
     * 根据 Id 查询学生信息
     * @param id
     * @return
     */
    
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }
}
