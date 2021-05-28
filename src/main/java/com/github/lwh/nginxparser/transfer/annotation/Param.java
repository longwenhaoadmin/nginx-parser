package com.github.lwh.nginxparser.transfer.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 单个配置描述元数据
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 22 : 29
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    String value() default "";

}
