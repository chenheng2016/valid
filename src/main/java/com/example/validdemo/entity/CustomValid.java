package com.example.validdemo.entity;

import com.example.validdemo.valid.custom.MyNumber;
import lombok.Data;

/**
 * @author chenheng
 * @time 2020/4/7 9:07
 */
@Data
public class CustomValid {

    @MyNumber(min = 3, max = 5, message = "值必须介于3和5之间")
    private Integer id;
}
