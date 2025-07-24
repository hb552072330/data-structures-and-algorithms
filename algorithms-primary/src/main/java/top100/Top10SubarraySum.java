package top100;

import java.util.HashMap;
import java.util.Map;

public class Top10SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int ans = 0;
        map.put(0, 1);
        for (int num : nums) {
            pre+=num;
            if(map.containsKey(pre - k)){
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
