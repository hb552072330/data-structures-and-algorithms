package class02;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2022/8/26
 */
public class Code03Comp {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static int[] lenRandomaValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        System.arraycopy(arr, 0, ans, 0, arr.length);
        return ans;
    }

    public static void jdkArraySort(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isSort(int[] arr, int[] target) {
        if (arr.length != target.length) {
            return false;
        }
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomaValueRandom(maxLen, maxValue);
            int[] copyArray = copyArray(arr);
            int[] copyArray2 = copyArray(arr);
            selectionSort(arr);
            insertionSort(copyArray);
            jdkArraySort(copyArray2);
            if (!isSort(arr, copyArray2) || !isSort(copyArray, copyArray2)) {
                System.out.println("排序出错了！！！");
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(copyArray));
                System.out.println(Arrays.toString(copyArray2));
                break;
            }
        }
    }
}
