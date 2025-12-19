package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 18:23
 **/
public class Top41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
//                int tmp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[tmp - 1] = tmp;
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
