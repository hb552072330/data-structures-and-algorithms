package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 20:59
 **/
public class Top283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int slow = 0, quick = 0;
        while (quick < nums.length) {
            if (nums[quick] != 0 && nums[slow] == 0) {
                nums[slow++] = nums[quick];
                nums[quick++] = 0;
            } else {
                quick++;
                if (nums[slow] != 0) {
                    slow++;
                }
            }
        }

    }

}
