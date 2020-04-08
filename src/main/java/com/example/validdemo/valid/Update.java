package com.example.validdemo.valid;

import com.example.validdemo.valid.rank.First;
import com.example.validdemo.valid.rank.Second;

import javax.validation.GroupSequence;

/**
 * 用于更新操作
 *
 * @author chenheng
 * @time 2020/4/6 13:46
 */
@GroupSequence({First.class, Second.class})
public interface Update {
}
