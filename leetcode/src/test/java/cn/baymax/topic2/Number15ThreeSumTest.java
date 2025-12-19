package cn.baymax.topic2;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/3/4
 */
public class Number15ThreeSumTest extends TestCase {

    public void testThreeSum() {
        //运行成功: 测试用例:[-1,0,1,2,-1,-4] 测试结果:[[-1,-1,2],[-1,0,1],[-1,0,1]] 期望结果:[[-1,-1,2],[-1,0,1]] stdout
        int[] arr = {-1,0,1,2,-1,-4};
        //解答失败: 测试用例:[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
        // 测试结果:[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2],[-2,0,2]]
        // 期望结果:[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]] stdout:
        int[] arr2 = {0,0,0};
        System.out.println(new Number15ThreeSum().threeSum(arr2));
    }
}