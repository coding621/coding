package com.morpheus.coding.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author morpheus
 * @description 网关启动程序
 * @date 2025年6月27日19:13:46
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class CodingGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingGatewayApplication.class, args);
    }
}