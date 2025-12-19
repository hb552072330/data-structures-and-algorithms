package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-28 14:59
 **/
public class Code04 {

    public Integer maxVal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int ans = nums[0];
        int len = nums.length;
        long max = ans;
        long min = ans;
        for (int i = 1; i < len; i++) {
            long mx = max;
            long mn = min;
            max = Math.max(mx * nums[i],
                    Math.max(nums[i], mn * nums[i]));
            min = Math.min(mx * nums[i],
                    Math.min(nums[i], mn * nums[i]));
            ans = Math.max((int) max, ans);
        }

        return ans;
    }
}
