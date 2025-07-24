package top100;

import java.util.*;

public class Top03LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int currentNum = nums[0];
        set.add(currentNum);
        int tempCount = 1;
        ans = 1;
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
//            System.out.println(currentNum + "   " + tempCount);
            if (++currentNum == num) {
                if (++tempCount > ans) {
                    ans = tempCount;
                }
            } else {
                currentNum = num;
                tempCount = 1;
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
        nums = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
}
