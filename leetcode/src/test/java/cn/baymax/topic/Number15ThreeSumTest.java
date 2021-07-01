package cn.baymax.topic;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/7/1
 */
public class Number15ThreeSumTest {

    @Test
    public void threeSum() {
        int[] arr = {-1,0,1,2,-1,-4};
        Number15ThreeSum number15ThreeSum = new Number15ThreeSum();
        List<List<Integer>> lists = number15ThreeSum.threeSum(arr);
        System.out.println(lists);
    }
}