package cn.baymax.topic;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针 排序
// 👍 3445 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2021/6/25
 */
public class Number15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序集合
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int current = 0; current < nums.length; current++) {
            int currentNum = nums[current];
            if (currentNum > 0) {
                break;
            }
            //存在相同值舍弃
            if (current > 0 && currentNum == nums[current - 1]) {
                continue;
            }
            //双指针处理
            int left = current + 1;
            int right = nums.length - 1;
            while (left < right) {
                //如果左右指针相加小于当前指针的值，移动左指针，反之移动右指针
                if (nums[left] + nums[right] < -currentNum) {
                    left++;
                } else if (nums[left] + nums[right] > -currentNum) {
                    right--;
                } else if (nums[left] + nums[right] == -currentNum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[current]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
