package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 21:29
 **/
public class Top42 {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int ans = 0;
        int l = 0, r = height.length - 1;
        int min = Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > min) {
                    min = height[l];
                } else {
                    ans += (min - height[l]);
                }
                l++;
            } else {
                if (height[r] > min) {
                    min = height[r];
                } else {
                    ans += (min - height[r]);
                }
                r--;
            }
        }
        return ans;
    }
}
