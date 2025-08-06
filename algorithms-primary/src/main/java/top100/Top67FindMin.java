package top100;

public class Top67FindMin {

    //输入：nums = [3,4,5,1,2]
    //输出：1
    //解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
    //
    //
    // 示例 2：
    //
    //
    //输入：nums = [4,5,6,7,0,1,2]
    //输出：0
    //解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
