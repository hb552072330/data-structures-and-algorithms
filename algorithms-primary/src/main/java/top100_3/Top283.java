package top100_3;

import java.util.Arrays;

/**
 * @Author zhanghongbing
 * @Date 2025-10-10 23:26
 **/
public class Top283 {
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int quickIdx = 1, slowIdx = 0;
        while (quickIdx < nums.length) {
            if (nums[quickIdx] != 0 && nums[slowIdx] == 0) {
                nums[slowIdx++]  = nums[quickIdx];
                nums[quickIdx++] = 0;
            } else {
                quickIdx++;
                if (nums[slowIdx] != 0) {
                    slowIdx++;
                }
            }
        }

    }

    public static void moveZeroes(int[] nums) {
        if (nums == null) return;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (nums[l] == 0 && r < nums.length) {
                if (nums[r] == 0) {
                    r++;
                } else {
                    nums[l] = nums[r];
                    nums[r] = 0;
                }
            }
            l++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
