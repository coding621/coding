package com.morpheus.coding.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author morpheus
 * @description 监控中心
 * @date 2025年6月27日21:38:59
 */
@EnableAdminServer
@SpringBootApplication
@RefreshScope
public class CodingMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingMonitorApplication.class, args);
    }
}