package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top06ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int currIdx = 0;
        while (currIdx < nums.length - 2) {
            if (currIdx > 0 && nums[currIdx] == nums[currIdx - 1]) {
                currIdx++;
                continue;
            }
            int endIdx = nums.length - 1;
            int starIdx = currIdx + 1;
            while (starIdx< endIdx){
                if(starIdx > currIdx +1 && nums[starIdx] == nums[starIdx -1]){
                    starIdx++;
                    continue;
                }
                while (starIdx < endIdx && (nums[currIdx] + nums[endIdx] + nums[starIdx])> 0) {
                    endIdx--;
                }
                if(starIdx == endIdx){break;}
                if(nums[currIdx] + nums[endIdx] + nums[starIdx]== 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[currIdx]);
                    list.add(nums[starIdx]);
                    list.add(nums[endIdx]);
                    ans.add(list);
                }
                starIdx++;
            }
            currIdx++;
        }

        return ans;
    }

    //[-1,0,1,2,-1,-
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
        arr = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(arr));
        arr = new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(threeSum(arr));
    }
}
