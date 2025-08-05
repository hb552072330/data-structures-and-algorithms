package top100;

public class Top63SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        int ans = nums.length;
        int L = 0, R = ans - 1;
        while (L <= R) {
            int mid = ((R - L) >> 1) + L;
            if (target <= nums[mid]) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
}
