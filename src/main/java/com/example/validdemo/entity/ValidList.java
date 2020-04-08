package com.example.validdemo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chenheng
 * @time 2020/4/6 11:07
 */
@Data
public class ValidList {

    @NotNull
    private Integer id ;

    @NotBlank
    private String username;
}
