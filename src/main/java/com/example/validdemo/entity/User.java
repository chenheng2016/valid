package com.example.validdemo.entity;

import com.example.validdemo.valid.Insert;
import com.example.validdemo.valid.Update;
import com.example.validdemo.valid.rank.First;
import com.example.validdemo.valid.rank.Second;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author chenheng
 * @time 2020/4/6 13:47
 */
@Data
public class User {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    @NotBlank(message = "用户名不能为空", groups = {Insert.class, Update.class})
    private String username;

    /**
     * 分组排序校验
     */
    @Size(min = 10,message = "长度不能小于10", groups = First.class)
    @Email(message = "邮箱格式不符", groups = Second.class)
    private String email;
}
