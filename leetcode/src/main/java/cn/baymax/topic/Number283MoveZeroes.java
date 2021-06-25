package cn.baymax.topic;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1099 👎 0

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index++] = nums[i];
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int l = 0, r = 0, lenth = nums.length;
        while (l < lenth) {
            if (nums[l] != 0) {
                if (l != r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
                r++;
            }
            l++;
        }
    }
}
