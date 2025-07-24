package top100;

public class Top14MaxSubArray {

    public static int maxSubArray(int[] nums) {

        if(nums == null|| nums.length==0){
            return 0;
        }
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
        int ans = nums[0];
        int preMax = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            System.out.println(preMax);
            if (nums[i] > preMax + nums[i]) {
                preMax =  nums[i];
            } else {
                preMax = nums[i] + preMax ;
            }
            ans = Math.max(ans, preMax);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
