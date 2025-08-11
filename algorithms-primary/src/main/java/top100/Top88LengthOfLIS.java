package top100;

public class Top88LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        int[] end = new int[len];
        end[0] = nums[0];
        int right = 0;
        ans = 1;
        for (int i = 1; i < len; i++) {
            int l = 0;
            int r = 0;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[i] > end[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            right = Math.max(right, l);
            end[l] = nums[i];
            ans = Math.max(ans, l + 1);
        }

        return ans;
    }
}
