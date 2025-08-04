package top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Top55Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        permuteProcess(ans, 0, output, nums.length);
        return ans;
    }

    private void permuteProcess(List<List<Integer>> ans, int first, List<Integer> output, int length) {
        if (first == length) {
            ans.add(new ArrayList<>(output));
        } else {
            for (int i = first; i < length; i++) {
                Collections.swap(output, first, i);
                permuteProcess(ans, first + 1, output, length);
                Collections.swap(output, first, i);
            }
        }
    }
}
