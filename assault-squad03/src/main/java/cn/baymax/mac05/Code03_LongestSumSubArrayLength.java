package cn.baymax.mac05;

import java.util.HashMap;
import java.util.Map;

public class Code03_LongestSumSubArrayLength {

    public int maxSubArrayLen(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i] + sum;
            if (map.containsKey(sum - k)) {
                Integer constainIndex = map.get(sum - k);
                ans = Math.max(ans, i - constainIndex);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
