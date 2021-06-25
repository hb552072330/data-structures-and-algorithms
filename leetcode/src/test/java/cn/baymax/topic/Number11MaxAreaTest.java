package cn.baymax.topic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number11MaxAreaTest {
    int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    Number11MaxArea number11MaxArea = new Number11MaxArea();
    @Test
    public void maxArea() {
        System.out.println(number11MaxArea.maxArea(arr));
    }


    @Test
    public void maxArea2() {
        System.out.println(number11MaxArea.maxArea2(arr));
    }
}