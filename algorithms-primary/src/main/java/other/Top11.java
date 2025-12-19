package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 21:11
 **/
public class Top11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, height[r] * (r - l));
                l++;
            } else {
                ans = Math.max(ans, height[l] * (r - l));
                r--;
            }
        }
        return ans;
    }

}
