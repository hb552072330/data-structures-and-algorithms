package top100_2;

import java.util.HashMap;
import java.util.Map;

public class Top01TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return null;
    }
}
