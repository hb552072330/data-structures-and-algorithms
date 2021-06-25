package cn.baymax.topic;


import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number283MoveZeroesTest {
    @Test
    public void moveZeroes() {
        int arr[] = {0,1,0,3,12};
        Number283MoveZeroes moveZeroes = new Number283MoveZeroes();
        moveZeroes.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMoveZeroes() {
        int arr[] = {0,1,0,3,12};
        Number283MoveZeroes moveZeroes = new Number283MoveZeroes();
        moveZeroes.moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }
}