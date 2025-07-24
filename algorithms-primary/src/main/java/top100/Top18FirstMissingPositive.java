package top100;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Top18FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int L = -1, R = len;
        int ans = len + 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            while ((curr <= i || curr >= ans || (curr > i && curr < ans)) && i < R) {
                if (curr == i + 1) {
                    L++;
                    break;
                }
                if (curr <= i || curr >= ans || nums[curr - 1] == curr) {
                    if(R == i){
                        ans--;
                        break;
                    }
                    int temp = nums[--R];
                    nums[R] = curr;
                    nums[i] = temp;
                    curr = temp;
                    ans--;
                } else {
                    int temp = nums[curr-1];
                    nums[curr-1] = curr;
                    nums[i] = temp;
                    curr = temp;
                }
            }
            if(i > R){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{2}));
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }
    //输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。
}
