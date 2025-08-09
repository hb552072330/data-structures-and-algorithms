package top100;

public class Top82ClimbStairs {

    public int climbStairs(int n) {
        int ans = 1, pre = 0, tmp = 0;
        for (int i = 1; i <= n; i++) {
            tmp = ans;
            ans = pre + ans;
            pre = tmp;
        }
        return ans;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int ans = 2;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = ans;
            ans = pre + ans;
            pre = tmp;
        }
        return ans;
    }

}
