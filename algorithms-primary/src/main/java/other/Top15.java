package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhanghongbing
 * @Date 2025-11-20 21:15
 **/
public class Top15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int currIdx = 0;
        while (currIdx < nums.length - 2) {
            //边界问题 重复
            if (currIdx > 0 && nums[currIdx] == nums[currIdx - 1]) {
                currIdx++;
                continue;
            }
            int startIdx = currIdx + 1;
            int endIdx = nums.length - 1;
            while (startIdx < endIdx) {
                if (nums[startIdx] + nums[endIdx] == -nums[currIdx]) {
                    List<Integer> curList = new ArrayList<Integer>();
                    curList.add(nums[currIdx]);
                    curList.add(nums[startIdx]);
                    curList.add(nums[endIdx]);
                    ans.add(curList);
                    //重复值，边界问题
                    while (startIdx + 1 < endIdx && nums[startIdx] == nums[startIdx + 1]) {
                        startIdx++;
                    }
                    while (endIdx - 1 > startIdx && nums[endIdx] == nums[endIdx - 1]) {
                        endIdx--;
                    }
                    startIdx++;
                    endIdx--;

                } else if (nums[startIdx] + nums[endIdx] > -nums[currIdx]) {
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
