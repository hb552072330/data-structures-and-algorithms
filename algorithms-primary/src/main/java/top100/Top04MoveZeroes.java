package top100;

import java.util.Arrays;

public class Top04MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int slowIdx = 0;
        int quickIdx = 1;
        while (quickIdx < nums.length) {
            if (nums[slowIdx] == 0 && nums[quickIdx] != 0) {
                nums[slowIdx] = nums[quickIdx];
                nums[quickIdx] = 0;
                quickIdx++;
                slowIdx++;
            } else {
                quickIdx++;
                if(nums[slowIdx] != 0){
                    slowIdx++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{0, 1, 0, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 0, 1};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
