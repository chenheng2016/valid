package com.example.validdemo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chenheng
 * @time 2020/4/6 9:24
 */
@Data
public class Person {

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "年龄不能为空")
    private Integer age;

}
