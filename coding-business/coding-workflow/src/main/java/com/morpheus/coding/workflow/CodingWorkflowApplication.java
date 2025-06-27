package com.morpheus.coding.workflow;

import com.morpheus.coding.footstone.security.annotation.EnableCustomConfig;
import com.morpheus.coding.footstone.security.annotation.EnableDistributedLock;
import com.morpheus.coding.footstone.security.annotation.EnablePmFeignClients;
import com.morpheus.coding.footstone.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author morpheus
 * @description 工作流服务
 * @date 2025年6月27日21:38:59
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@EnableDistributedLock // 启用Redisson分布式锁
@SpringBootApplication
public class CodingWorkflowApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodingWorkflowApplication.class, args);
    }
}