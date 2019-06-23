package demo.yanming.springboot.configuration.processor;

import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.yanming.springboot.configuration.processor.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootValConproDemoApplicationTests {

    @Autowired
    private Student student;

    @Test
    public void contextLoads() {
        // 这里为了方便，但工作中千万不能用 System.out
        System.out.println(student.toString());
    }

}
