package cn.baymax.mac01;

import java.util.Arrays;

public class Code03_BinarySearch {

    public static boolean exist(int[] sortArray, int num) {
        int l = 0;
        int r = sortArray.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (sortArray[mid] > num) {
                r = mid - 1;
            } else if (sortArray[mid] < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //在arr上，找满足>=value的最左位置
    public static int nearest(int[] sortArray, int num) {
        int l = 0;
        int r = sortArray.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (sortArray[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // 在arr上，找满足<=value的最右位置
    public static int nearestRight(int[] sortArray, int num) {
        int l = 0;
        int ans = 0;
        int r = sortArray.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if(sortArray[mid] <= num){
                ans = mid;
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return ans;
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
        int maxValue = 15;
        int[] ints = generateRandomArray(maxSize, maxValue);
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(exist(ints, 15));
        int nearest = nearest(ints, 20);
        System.out.println("nearest(ints, 20)=" +nearest+ ",arr value = "+ ints[nearest]);
        int nearestRight = nearestRight(ints, 20);
        System.out.println("nearestRight(ints, 20)=" +nearestRight+ ",arr value = "+ ints[nearestRight]);
        System.out.println();
        System.out.println("length" + ints.length);

    }

}
