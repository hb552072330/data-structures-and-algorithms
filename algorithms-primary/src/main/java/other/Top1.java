package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 21:42
 **/
public class Top1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            } else {
                map.put( nums[i], i);
            }
        }
        return ans;
    }
}
