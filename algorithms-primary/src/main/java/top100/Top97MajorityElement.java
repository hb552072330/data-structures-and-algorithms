package top100;

public class Top97MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            count = ans == num ? count + 1 : count - 1;
        }
        return ans;
    }
}
