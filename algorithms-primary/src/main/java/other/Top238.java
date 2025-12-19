package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 17:54
 **/
public class Top238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = R * ans[i];
            R *= nums[i];
        }
        return ans;
    }
}
