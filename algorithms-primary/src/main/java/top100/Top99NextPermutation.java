package top100;

import java.util.Arrays;

public class Top99NextPermutation {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int L) {
        int R = nums.length - 1;
        while (L < R) {
            swap(nums, L, R);
            L++;
            R--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 1, 3};
//        测试用例:[1,3,2]
//        测试结果:[3,1,2]
//        期望结果:[2,1,3]
        int[] nums = {1, 3, 2};
//        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
