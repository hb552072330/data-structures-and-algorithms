package top100;

public class Top79CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxStep = 0;
        for (int i = 0; i < len; i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (maxStep >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int step = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (step <= 0) {
                return false;
            }
            if (--step < nums[i]) {
                step = nums[i];
            }
        }
        return true;
    }
}
