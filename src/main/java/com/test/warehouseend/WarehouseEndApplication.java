package com.test.warehouseend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.warehouseend.mapper")
public class WarehouseEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseEndApplication.class, args);
    }

}
