package com.test.warehouseend.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 表示这是一个配置类
@MapperScan("com.test.warehouseend.mapper")  // 扫描你的 Mapper 接口所在的包
public class MyBatisPlusConfig {
    @Bean  // 将 MybatisPlusInterceptor 注册为 Spring 容器的 Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());  // 添加分页插件
        return interceptor;
    }
}
