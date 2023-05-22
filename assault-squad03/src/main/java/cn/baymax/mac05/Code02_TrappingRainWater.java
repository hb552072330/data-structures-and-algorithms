package cn.baymax.mac05;

//https://leetcode.cn/problems/trapping-rain-water/
//
public class Code02_TrappingRainWater {
    public int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int water = 0;
        int len = height.length;
        int L = 1;
        int R = len - 2;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        while (L <= R) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - height[L]);
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                water += Math.max(0, rightMax - height[R]);
                rightMax = Math.max(rightMax, height[R--]);
            }
        }
        return water;
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int maxL = height[l];
            while (l < r && height[l] <= height[r]) {
                if (maxL < height[l + 1]) {
                    maxL = height[l + 1];
                } else {
                    ans = ans + maxL - height[l + 1];
                }
                l++;
            }
            int maxR = height[r];
            while (l < r && height[l] > height[r]) {
                if (maxR < height[r - 1]) {
                    maxR = height[r - 1];
                } else {
                    ans = ans + maxR - height[r - 1];
                }
                r--;
            }
        }
        return ans;
    }
}
