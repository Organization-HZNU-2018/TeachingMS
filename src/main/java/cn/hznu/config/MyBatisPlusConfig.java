package cn.hznu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 自动管理事务，默认开启
@EnableTransactionManagement
@Configuration
@MapperScan("cn.hznu.mapper")
public class MyBatisPlusConfig {
}
