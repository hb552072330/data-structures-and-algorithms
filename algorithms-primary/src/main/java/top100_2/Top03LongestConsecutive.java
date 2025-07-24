package top100_2;

import java.util.HashSet;
import java.util.Set;

public class Top03LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int ans = 0;
        for (Integer num : numSet) {
            int current = num;
            if (!numSet.contains(current - 1)) {
                int count = 1;
                while (numSet.contains(current++)) {
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
        nums = new int[]{1, 0, 1, 2};
        System.out.println(longestConsecutive(nums));
        nums = new int[]{0};
        System.out.println(longestConsecutive(nums));
        nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(longestConsecutive(nums));
    }

}
