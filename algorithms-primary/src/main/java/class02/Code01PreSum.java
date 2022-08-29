package class02;

/**
 * @author zhanghongbing
 * @data 2022/8/24
 */
public class Code01PreSum {

    public static class RangeSum1 {
        private int[] arr;

        public RangeSum1(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static class RangeSum2 {
        private int[] arr;

        public RangeSum2(int[] arr) {
            int[] newArr = new int[arr.length];
            newArr[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                newArr[i] = newArr[i - 1] + arr[i];
            }
            this.arr = newArr;
        }

        public int rangeSum(int left, int right) {
            return left == 0 ? arr[right] : arr[right] - arr[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RangeSum1 rangeSum1 = new RangeSum1(arr);
        System.out.println(rangeSum1.rangeSum(3, 3));
        RangeSum2 rangeSum2 = new RangeSum2(arr);
        System.out.println(rangeSum2.rangeSum(3, 3));
    }

}
