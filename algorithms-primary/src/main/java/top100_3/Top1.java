package top100_3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhanghongbing
 * @Date 2025-10-10 22:32
 **/
public class Top1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                ans[0] = map.get(target - nums[i]);
//                ans[1] = i;
//                break;
//            }
//            map.put(nums[i], i);
//        }
        return ans;
    }
}
