package com.morpheus.coding.gen;

import com.morpheus.coding.footstone.security.annotation.EnableCustomConfig;
import com.morpheus.coding.footstone.security.annotation.EnablePmFeignClients;
import com.morpheus.coding.footstone.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author morpheus
 * @description 代码生成
 * @date 2025年6月27日21:38:59
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class CodingGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingGenApplication.class, args);
    }
}