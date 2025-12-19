package top100_3;

/**
 * @Author zhanghongbing
 * @Date 2025-10-13 14:23
 **/
public class Top42 {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = height.length - 1;
        int mid = Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] < height[r]) {
                if (mid > height[l]) {
                    ans += (mid - height[l]);
                } else {
                    mid = height[l];
                }
                l++;
            } else {
                if (mid > height[r]) {
                    ans += (mid - height[r]);
                } else {
                    mid = height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
