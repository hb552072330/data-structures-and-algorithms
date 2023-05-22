package cn.baymax.mac05;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/longest-well-performing-interval/
//1124
public class Code04_LongestWellPerformingInterval {


    public int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) {
            return 0;
        }
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < hours.length; i++) {
            sum += (hours[i] > 8 ? 1 : -1);
            if (sum > 0) {
                ans = i + 1;
            } else {
                if (map.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }

}
