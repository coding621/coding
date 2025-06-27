package com.morpheus.coding.system;

import com.morpheus.coding.footstone.security.annotation.EnableCustomConfig;
import com.morpheus.coding.footstone.security.annotation.EnablePmFeignClients;
import com.morpheus.coding.footstone.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author morpheus
 * @description 系统模块
 * @date 2025年6月27日21:38:59
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class CodingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingSystemApplication.class, args);
    }
}