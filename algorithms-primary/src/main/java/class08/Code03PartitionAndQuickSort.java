package class08;

import java.util.Arrays;
import java.util.Stack;

public class Code03PartitionAndQuickSort {
    public static void spiltNum1(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int N = arr.length;
        while (index < N) {
            if (arr[index] <= arr[N - 1]) {
                swap(arr, ++lessEqualR, index++);
            } else {
                index++;
            }
        }
    }

    public static void spiltNum2(int[] arr) {
        int lessEqualR = -1;
        int index = 0;
        int N = arr.length;
        int moreL = N - 1;
        while (index < moreL) {
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++lessEqualR, index++);
            } else if (arr[index] > arr[N - 1]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, N - 1);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equlsE = partition(arr, L, R);
        process(arr, L, equlsE[0] - 1);
        process(arr, equlsE[0] + 1, R);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int lessR = l - 1;
        int moreL = r;
        int index = l;
        while (index < moreL) {
            if (arr[index] < arr[r]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[r]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, r);
        return new int[]{lessR + 1, moreL};
    }


    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 1000;
//        testSplitNum1(maxSize, maxValue);
//        testSplitNum2(maxSize, maxValue);
        int testTimes = 100000;
        System.out.println("test begin");
        boolean isSucceed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            helpSort(arr1);
            quickSort1(arr2);
            quickSort2(arr3);
            quickSort3(arr4);
            if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3) || !isEqual(arr1, arr4)) {
                System.out.println("Oops!");
                isSucceed = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                System.out.println(Arrays.toString(arr4));
                break;
            }

        }
        System.out.println("test end");
        System.out.println(isSucceed ? "Nice" : "Oops!");
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[0] + 1, R);
    }

    private static int[] netherlandsFlag(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int lessL = l - 1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] < arr[r]) {
                swap(arr, index++, ++lessL);
            } else if (arr[index] > arr[r]) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        swap(arr, more, r);
        return new int[]{lessL + 1, more};
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
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
    }

    private static void helpSort(int[] arr) {
        Arrays.sort(arr);
    }

    public static class Job {
        private int L;
        private int R;

        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job current = stack.pop();
            int[] equals = partition(arr, current.L, current.R);
            if (equals[0] > current.L) {
                stack.push(new Job(current.L, equals[0] - 1));
            }
            if (equals[1] < current.R) {
                stack.push(new Job(equals[1] + 1, current.R));
            }
        }
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static void testSplitNum1(int maxSize, int maxValue) {
        int[] ints = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(ints));
        System.out.println(ints[ints.length - 1]);
        spiltNum1(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("------");
    }

    private static void testSplitNum2(int maxSize, int maxValue) {
        int[] ints = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(ints));
        System.out.println(ints[ints.length - 1]);
        spiltNum2(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("------");
    }
}
