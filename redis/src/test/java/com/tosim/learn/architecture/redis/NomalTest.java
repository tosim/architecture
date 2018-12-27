package com.tosim.learn.architecture.redis;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yaoyicheng
 * @data 2018/12/27 9:45
 */
public class NomalTest {
    @Test
    public void StreamTest() {
        List<Long> idList = Arrays.asList(12L, 21L, 55L);
        List<Long> newIdList = idList.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(newIdList);
    }
}
