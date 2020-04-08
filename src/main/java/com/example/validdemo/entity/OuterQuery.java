package com.example.validdemo.entity;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author chenheng
 * @time 2020/4/6 10:54
 */
@Data
public class OuterQuery {

    private Integer id;

    @Valid
    @NotEmpty(message = "集合不能为空")
    private List<InnerQuery> list;

    @Data
    private static final class InnerQuery {

        @NotBlank(message = "username不能为空")
        private String username;

    }
}


