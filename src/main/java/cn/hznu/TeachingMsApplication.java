package cn.hznu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class TeachingMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachingMsApplication.class, args);
    }

}
