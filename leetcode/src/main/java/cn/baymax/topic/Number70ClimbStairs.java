package cn.baymax.topic;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 记忆化搜索 数学 动态规划
// 👍 1712 👎 0

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number70ClimbStairs {
    //滚动数组
    public int climbStairs(int n) {
        int res = 1, pre1 = 0, pre2 = 0;
        for (int i = 0; i < n; i++) {
            pre2 = pre1;
            pre1 = res;
            res = pre1 + pre2;
        }
        return res;
    }
}
