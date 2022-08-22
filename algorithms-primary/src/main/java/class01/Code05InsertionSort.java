package class01;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2022/8/19
 */
public class Code05InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 0~1 0，1和前一个比较，1小往前插入
     * 0~2 1，2和前一个比较，1小往前插入，直至不小于或者跑到最前
     * @param arr
     */
    public static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {//第一个if走完，这里存在隐士比较 (arr1 == null & arr2 != null) || (arr1 != null && arr2 == null)
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
        //if((arr1 == null & arr2 != null) || (arr1 != null && arr2 == null)){
        //    return false;
        //}
        //if(arr1)
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1))
                    - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int length = arr.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        //int arr[] = {3, 2, 1, 7, 5, 9, 4, 6, 0, 8};
        //printArray(arr);
        //insertionSort2(arr);
        //printArray(arr);

        int testTimes = 50000;
        int maxValue = 100;
        int maxSize = 100;

        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort2(arr);
        printArray(arr);
    }
}
