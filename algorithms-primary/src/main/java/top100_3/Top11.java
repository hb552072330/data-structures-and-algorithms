package top100_3;

/**
 * @Author zhanghongbing
 * @Date 2025-10-12 22:10
 **/
public class Top11 {
    public void moveZero(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int slowIdx = 0, quickIdx = 1;
        while (quickIdx < nums.length) {
            if (nums[slowIdx] == 0 && nums[quickIdx] != 0) {
                nums[slowIdx++] = nums[quickIdx];
                nums[quickIdx++] = 0;
            } else {
                quickIdx++;
                if (nums[slowIdx] != 0) {
                    slowIdx++;
                }
            }
        }
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max((r - l) * (Math.min(height[l], height[r])), ans);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
