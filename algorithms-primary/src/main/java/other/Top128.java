package other;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 18:52
 **/
public class Top128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int count = 0;
                while (set.contains(curr++)) {
                    count++;
                }
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }
}
