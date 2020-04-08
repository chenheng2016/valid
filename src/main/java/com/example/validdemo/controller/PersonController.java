package com.example.validdemo.controller;

import com.example.validdemo.entity.*;
import com.example.validdemo.service.IPersonService;
import com.example.validdemo.valid.Insert;
import com.example.validdemo.valid.Update;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author chenheng
 * @time 2020/4/6 9:21
 */
@RestController
@RequestMapping("/person")
//@Validated
public class PersonController {

    @Autowired
    private IPersonService personService;

    @ApiOperation("添加用户")
    @PostMapping("/")
    public String addPerson(@Valid @RequestBody Person person/*, Errors errors*/) {
        //如果后面一个参数是Errors，则直接返回后面的东西
        return personService.addPerson(person);
    }

    @ApiOperation("根据id获取person信息")
    @PostMapping("/nestedQuery")
    public String getPerson(@Valid @RequestBody OuterQuery outerQuery) {
        return "";
    }

    @ApiOperation("validList校验")
    @PostMapping("/validList")
    public String validList(@Valid @RequestBody List<ValidList> list) {
        return "";
    }

    @ApiOperation("customValidList校验")
    @PostMapping("/customValidList")
    public String customValidList(@Valid @RequestBody CustomValidList<Person> list) {
        return "";
    }

    @ApiOperation("validInsertGroup校验")
    @PostMapping("/validInsertGroup")
    public String validInsertGroup(@Validated(Insert.class) @RequestBody User user) {

        return "";
    }

    @ApiOperation("validUpdateGroup校验")
    @PostMapping("/validUpdateGroup")
    public String validUpdateGroup(@Validated(Update.class) @RequestBody User user) {

        return "";
    }

    @ApiOperation("validUpdateSortGroup校验")
    @PostMapping("/validUpdateSortGroup")
    public String validUpdateSortGroup(@Validated(Update.class) @RequestBody User user) {
        return "";
    }

    @ApiOperation("validCustomAnntation校验")
    @PostMapping("/validCustomAnntation")
    public String validCustomAnntation(@Validated @RequestBody CustomValid customValid) {
        return "";
    }


    @ApiOperation("添加用户带BindingResult")
    @PostMapping("/addPersonWithBindingResult")
    public String addPersonWithBindingResult(@Valid @RequestBody Person person, /*HttpServletRequest request,*/BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuilder sb = new StringBuilder();
            allErrors.forEach(item -> {
                sb.append(item.getDefaultMessage()).append(".");
            });
            return sb.deleteCharAt(sb.lastIndexOf(".")).toString();
        }
        return personService.addPerson(person);
    }

    @ApiOperation("添加用户带GlobalExceptionHandler")
    @PostMapping("/addPersonWithGlobalExceptionHandler")
    public String addPersonWithGlobalExceptionHandler(@Valid @RequestBody Person person) {
        return personService.addPerson(person);
    }
}
