package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 12:31
 **/
public class Top189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || k < 1) {
            return;
        }
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
