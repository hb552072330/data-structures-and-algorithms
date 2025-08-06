package top100;

public class Top66Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
//        int ans = -1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 数组的头结点 <= 目标数  且目标数< 中间数 说明在前半段
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
//    输入：nums = [4,5,6,7,0,1,2], target = 0
//    输出：4
//    示例 2：
//
//    输入：nums = [4,5,6,7,0,1,2], target = 3

}
