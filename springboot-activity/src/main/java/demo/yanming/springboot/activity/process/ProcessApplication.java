package demo.yanming.springboot.activity.process;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//查看activiti-spring-boot-starter-basic-6.0.0.jar发现，org.activiti.spring.boot.SecurityAutoConfiguration编译报错，这时候将SecurityAutoConfiguration排除到SpringBoot启动之外，即@SpringBootApplication注解添加exclude = SecurityAutoConfiguration.class属性
//启动正常，查看数据库，Activiti6运行所需的28张表也已经创建成功。
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProcessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProcessApplication.class, args);
    }
}