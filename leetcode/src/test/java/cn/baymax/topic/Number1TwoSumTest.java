package cn.baymax.topic;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number1TwoSumTest {
    Number1TwoSum number1TwoSum = new Number1TwoSum();

    @Test
    public void twoSum() {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(number1TwoSum.twoSum(arr, 9)));
    }

    @Test
    public void twoSum2() {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(number1TwoSum.twoSum2(arr, 9)));
    }

}