package top100;

import java.util.Arrays;

public class Top98SortColors {
    public static void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i <= p2; i++) {
            while (nums[i] == 2 && i <= p2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }

        }

    }

    public static void sortColors2(int[] nums) {

        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                swap(nums, i, p1++);
            } else if (num == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
