package class03;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2022/8/29
 */
public class Code02BinarySearchNearLeft {

    public static int mostLeftBinarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= target) {
                ans = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }

    public static int loopSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] ans = new int[(int) ((Math.random() + 1) * maxSize)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) ((Math.random() + 1) * maxValue) - (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static void main(String[] args) {
        int testTimes = 50000;
        int maxSize = 15;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int target = (int) ((Math.random() + 1) * maxSize) - (int) (Math.random() * maxSize);
            if (loopSearch(arr, target) != mostLeftBinarySearch(arr, target)) {
                System.out.println("出错了！！！！");
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked");

    }
}
