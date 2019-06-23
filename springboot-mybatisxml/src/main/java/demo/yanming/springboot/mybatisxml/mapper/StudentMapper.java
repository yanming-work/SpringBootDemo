package demo.yanming.springboot.mybatisxml.mapper;

import demo.yanming.springboot.mybatisxml.model.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectStudents();

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
