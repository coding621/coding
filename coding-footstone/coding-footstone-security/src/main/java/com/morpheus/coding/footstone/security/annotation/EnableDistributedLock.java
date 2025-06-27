package com.morpheus.coding.footstone.security.annotation;

import com.morpheus.coding.footstone.security.aspect.DistributedLockAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author morpheus
 * @description EnableDistributedLock 元注解，开启分布式锁功能
 * @date 2025年6月27日21:38:59
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DistributedLockAspect.class})
public @interface EnableDistributedLock {
}
