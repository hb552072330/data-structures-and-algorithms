package top100;

public class Top96SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }


    public static void main(String[] args) {

        int a = 1;
        int b = 3;
        int i = a ^ b;
        int j = i ^ a;
        int k = i ^ b;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

    }
}
