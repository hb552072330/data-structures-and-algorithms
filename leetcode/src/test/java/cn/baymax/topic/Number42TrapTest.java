package cn.baymax.topic;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/4/11
 */
public class Number42TrapTest extends TestCase {

    public void testTrap() {
        Number42Trap trap = new Number42Trap();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(arr));
        System.out.println(trap.violenceTrap(arr));
        int[] arr2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap.trap(arr2));
        System.out.println(trap.violenceTrap(arr2));
    }
}