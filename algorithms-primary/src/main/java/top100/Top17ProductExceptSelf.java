package top100;

import java.util.Arrays;

public class Top17ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = nums[0];
        for (int i = len - 1; i > 0; i--) {
            if (i != len - 1) {
                ans[i] = nums[i] * ans[i + 1];
            } else {
                ans[i] = nums[i];
            }
        }
        int temp = 1;
        for (int i = 0; i < len; i++) {
            if(i + 1 < len){
                ans[i] = ans[i + 1] * temp;
            } else {
                ans[i] = temp;
            }
            temp *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
