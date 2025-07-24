package top100;

import java.util.Arrays;

public class Top16Rotate {
    public static void rotate(int[] nums, int k) {
        if (nums == null || k < 1) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        int L = nums.length - k , R = nums.length - 1;
        while (L < R) {
            swap(nums, L ,R);
            L++;
            R--;
        }
        L = 0;
        R = nums.length - k - 1;
        while (L < R) {
            swap(nums, L ,R);
            L++;
            R--;
        }
        L = 0;
        R = nums.length - 1;
        while (L < R) {
            swap(nums, L ,R);
            L++;
            R--;
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
//        rotate(arr,3);
//        System.out.println(Arrays.toString(arr));
//        arr = new int[]{-1,-100,3,99};
        //输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
        //	测试用例:[1,2]
        //			7
        //	测试结果:[1,2]
        //	期望结果:[2,1]
        //	stdout:
        //		[2, 1]
//        rotate(arr,2);
//        System.out.println(Arrays.toString(arr));
        arr = new int[]{1,2};
        rotate(arr,7);
        System.out.println(Arrays.toString(arr));
    }
}
