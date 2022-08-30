package class03;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2022/8/29
 */
public class Code01BinarySearchExist {

    public static boolean binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static boolean loopSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
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
            int target = (int) ((Math.random() + 1) * maxValue) - (int) (Math.random() * maxValue);
            if (loopSearch(arr, target) != binarySearch(arr, target)) {
                System.out.println("出错了！！！！");
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked");
    }
}
