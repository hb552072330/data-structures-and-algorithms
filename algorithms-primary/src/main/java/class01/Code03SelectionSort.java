package class01;

/**
 * @author zhanghongbing
 * @data 2022/8/19
 */
public class Code03SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minValue = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[minValue] > arr[j]) {
                    minValue = j;
                }
            }
            if (i != minValue) {
                swap(arr, i, minValue);
            }
        }
    }

    private static void swap(int[] arr, int i, int minValue) {
        int temp = arr[i];
        arr[i] = arr[minValue];
        arr[minValue] = temp;
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
        selectionSort(arr);
        printArray(arr);
    }
}
