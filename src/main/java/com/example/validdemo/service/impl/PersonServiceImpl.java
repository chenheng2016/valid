package com.example.validdemo.service.impl;

import com.example.validdemo.entity.Person;
import com.example.validdemo.service.IPersonService;
import org.springframework.stereotype.Service;

/**
 * @author chenheng
 * @time 2020/4/6 9:23
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Override
    public String addPerson(Person person) {

        //add
        return "添加成功";
    }
}
