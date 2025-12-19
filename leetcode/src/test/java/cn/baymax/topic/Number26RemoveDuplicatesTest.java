package cn.baymax.topic;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/4/11
 */
public class Number26RemoveDuplicatesTest extends TestCase {

    public void testRemoveDuplicates() {
        int[] arr = {0, 1, 1,2, 2, 2, 3, 3};
        Number26RemoveDuplicates number26RemoveDuplicates = new Number26RemoveDuplicates();
        System.out.println(number26RemoveDuplicates.removeDuplicates(arr));
    }
}