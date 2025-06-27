package com.morpheus.coding.project.domain.vo.project.log;

import java.lang.annotation.*;

/**
 * @author morpheus
 * @date 2025年6月27日21:38:59
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForUpdate {
    String fieldName() default "";
}
