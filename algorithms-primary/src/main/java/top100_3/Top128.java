package top100_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zhanghongbing
 * @Date 2025-10-10 23:03
 **/
public class Top128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int res = 1;
                while (set.contains(++curr)) {
                    res++;
                }
                ans = Math.max(res, ans);
            }
        }
        return ans;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int res = 1;
                while (set.contains(curr + 1)) {
                    curr += 1;
                    res += 1;
                }
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }

}
