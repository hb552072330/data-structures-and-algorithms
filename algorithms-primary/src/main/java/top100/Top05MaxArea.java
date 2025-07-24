package top100;

public class Top05MaxArea {

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;

        int starIdx = 0;
        int endIdx = height.length - 1;
        while (starIdx < endIdx) {
            int startNum = height[starIdx];
            int endNum = height[endIdx];
            ans = Math.max(ans, Math.min(startNum, endNum) * (endIdx - starIdx));
            if (startNum < endNum) {
                starIdx++;
            } else {
                endIdx--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

}
