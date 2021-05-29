package com.github.lwh.nginxparser.transfer.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Block Value
 *
 * @author longwenhao
 * @version 1.0, 2021/5/28 23 : 06
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BlockValue {

}
