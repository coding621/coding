package com.morpheus.coding.job;

import com.morpheus.coding.footstone.security.annotation.EnableCustomConfig;
import com.morpheus.coding.footstone.security.annotation.EnablePmFeignClients;
import com.morpheus.coding.footstone.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author morpheus
 * @description 定时任务
 * @date 2025年6月27日21:38:59
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class CodingJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingJobApplication.class, args);
    }
}