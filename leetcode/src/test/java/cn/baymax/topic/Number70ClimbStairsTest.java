package cn.baymax.topic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number70ClimbStairsTest {

    Number70ClimbStairs number70ClimbStairs = new Number70ClimbStairs();
    @Test
    public void climbStairs() {
        System.out.println(number70ClimbStairs.climbStairs(1));
        System.out.println(number70ClimbStairs.climbStairs(2));
        System.out.println(number70ClimbStairs.climbStairs(3));
        System.out.println(number70ClimbStairs.climbStairs(4));
        System.out.println(number70ClimbStairs.climbStairs(5));
    }
}