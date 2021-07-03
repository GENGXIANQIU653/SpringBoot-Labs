package cn.iocoder.springboot.lab30.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 在类上，添加 @ImportResource 注解，引入 dubbo.xml 配置文件
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class ProviderApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(ProviderApplication.class, args);
    }

}
