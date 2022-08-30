package class03;

/**
 * @author zhanghongbing
 * @data 2022/8/30
 */
public class Code04BinarySearchSome {

    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        if (len > 0) {
            ans[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    ans[i] = (int) (Math.random() * maxValue);
                } while (ans[i] == ans[i - 1]);
            }
        }
        return ans;
    }

    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[len - 2] > arr[len - 1]) {
            return len - 1;
        }
        int left = 0;
        int right = len - 1;
        //2，1，3，5
        // 第一次循环 mid  2   left 0 right 1
        //left < right - 1 如果right不减1，就会索引越界
        while (left < right - 1) {
            int middle = (left + right) / 2;
            if (arr[middle] < arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                return middle;
            } else {
                if (arr[middle] > arr[middle - 1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return arr[left] < arr[right] ? left : right;
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 10000000;
        System.out.println("测试开始");
        //printArray(randomArray(maxLen, maxValue));
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
