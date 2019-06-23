package demo.yanming.springboot.mongodb.service;

import demo.yanming.springboot.mongodb.domain.Student;
import java.util.List;

/**
 * Project Name:springboot_mongodb_demo <br/>
 * Package Name:demo.yanming.springboot.mongodb.service <br/>
 * Date:2019/3/9 17:18 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public interface StudentService {

    Student addStudent(Student student);

    void deleteStudent(String id);

    Student updateStudent(Student student);

    Student findStudentById(String id);

    List<Student> findAllStudent();

}
