package cn.liuawen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.liuawen.dao")
public class PindongdongApplication {

    public static void main(String[] args) {
        SpringApplication.run(PindongdongApplication.class, args);
    }

}
