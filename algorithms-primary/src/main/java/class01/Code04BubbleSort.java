package class01;

/**
 * @author zhanghongbing
 * @data 2022/8/19
 */
public class Code04BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];//arr[i]= 1, arr[j] = 2  , 1 ^ 2 =  3
        arr[j] = arr[i] ^ arr[j];// 3 ^ 2 = 1
        arr[i] = arr[i] ^ arr[j];// 3 ^ 1 = 2
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int end = len - 1; end >= 0; end--) {
            for (int j = 1; j < end; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
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

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 7, 5, 9, 4, 6, 0, 8};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
