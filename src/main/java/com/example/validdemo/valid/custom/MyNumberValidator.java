package com.example.validdemo.valid.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 解析MyNumber注解
 *
 * @author chenheng
 * @time 2020/4/7 9:02
 */
public class MyNumberValidator implements ConstraintValidator<MyNumber, Integer> {

    private int min;

    private int max;

    @Override
    public void initialize(MyNumber myNumber) {
        this.min = myNumber.min();
        this.max = myNumber.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value >= this.min && value <= this.max) {
            return true;
        }

        return false;
    }
}
