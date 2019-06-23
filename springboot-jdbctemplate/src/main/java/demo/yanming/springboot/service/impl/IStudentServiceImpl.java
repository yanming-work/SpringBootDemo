package demo.yanming.springboot.service.impl;

import demo.yanming.springboot.dao.IStudentDao;
import demo.yanming.springboot.domain.Student;
import demo.yanming.springboot.service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Project Name:jdbctemplate_demo <br/>
 * Package Name:demo.yanming.springboot.service.impl <br/>
 * Date:2019/2/3 11:18 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Repository
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao iStudentDao;

    
    public int add(Student student) {
        return iStudentDao.add(student);
    }

    
    public int update(Student student) {
        return iStudentDao.update(student);
    }

    
    public int delete(int id) {
        return iStudentDao.delete(id);
    }

    
    public Student findStudentById(int id) {
        return iStudentDao.findStudentById(id);
    }

    
    public List<Student> findStudentList() {
        return iStudentDao.findStudentList();
    }

}
