package top100;

public class Top80Jump {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int step = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                step++;
                cur = next;
            }
            next = Math.max(next, i + nums[i]);
        }
        return step;
    }

    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int step = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(--next, nums[i]);
            if (cur <= i && i != nums.length - 1) {
                step++;
                cur += next;
                next = 0;
            }
        }

        return step;
    }


    public static void main(String[] args) {
//        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{3, 4, 3, 2, 5, 4, 3}));
    }
}
