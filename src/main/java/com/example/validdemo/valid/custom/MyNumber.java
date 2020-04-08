package com.example.validdemo.valid.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 定义支持数字的注解(支持最大值和最小值)
 * @author chenheng
 * @time 2020/4/7 9:01
 */
@Documented
@Constraint(validatedBy = {MyNumberValidator.class})//定义需要解析的类
@Target({FIELD})
@Retention(RUNTIME)
public @interface MyNumber {

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;

    String message() default "{javax.validation.constraints.NotEmpty.message}";

    // groups 这里主要进行将validator进行分类，不同的类group中会执行不同的validator操作
    Class<?>[] groups() default { };

    //payload 主要是针对bean的，使用不多。
    Class<? extends Payload>[] payload() default { };
}
