package top100_3;

import java.util.*;

/**
 * @Author zhanghongbing
 * @Date 2025-10-13 10:46
 **/
public class Top15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int currIdx = 0;
        while (currIdx < nums.length - 2) {
            if (currIdx > 0 && nums[currIdx] == nums[currIdx - 1]) {
                currIdx++;
                continue;
            }
            int startIdx = currIdx + 1;
            int endIdx = nums.length - 1;
            int target = -nums[currIdx];
            while (startIdx < endIdx) {
                if (nums[startIdx] + nums[endIdx] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[currIdx]);
                    list.add(nums[startIdx]);
                    list.add(nums[endIdx]);
                    ans.add(list);
                    while (startIdx + 1 < endIdx && nums[startIdx] == nums[startIdx + 1]) {
                        startIdx++;
                    }
                    while (endIdx - 1 > startIdx && nums[endIdx] == nums[endIdx - 1]) {
                        endIdx--;
                    }
                    startIdx++;
                    endIdx--;
                } else if (nums[startIdx] + nums[endIdx] > target) {
                    endIdx--;
                } else {
                    startIdx++;
                }
            }
            currIdx++;
        }
        return ans;
    }
}
