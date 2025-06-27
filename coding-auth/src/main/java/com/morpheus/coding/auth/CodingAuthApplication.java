package com.morpheus.coding.auth;

import com.morpheus.coding.footstone.security.annotation.EnablePmFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author morpheus
 * @description 认证授权中心
 * @date 2025年6月27日21:38:59
 */
@EnablePmFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CodingAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingAuthApplication.class, args);
    }
}