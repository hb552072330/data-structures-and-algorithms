package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 12:12
 **/
public class Top53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < num + preMax) {
                preMax += num;
            } else {
                preMax = num;
            }
            ans = Math.max(preMax, ans);
        }
        return ans;
    }
}
