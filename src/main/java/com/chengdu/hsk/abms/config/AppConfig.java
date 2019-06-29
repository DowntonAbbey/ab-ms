package com.chengdu.hsk.abms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Auther: hsk
 * @Date: 2019/6/1 19:53
 * @Description:
 */
@SpringBootConfiguration
@ComponentScan("com.chengdu.hsk.abms")
@MapperScan(basePackages = {"com.chengdu.hsk.abms.mapper"})
public class AppConfig {
}
