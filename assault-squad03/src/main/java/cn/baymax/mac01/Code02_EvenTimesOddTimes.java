package cn.baymax.mac01;

import java.util.Arrays;

public class Code02_EvenTimesOddTimes {
    /**
     * 已知一个数组中
     * 只有一种数出现了奇数次
     * 其他数都出现了偶数次
     * 找到出现了奇数次的数
     */

    public static void findOddTimes(int[] arr) {
        if (arr == null || arr.length < 0) {
            System.out.println("数组不合法！");
        }
        int a = 0;
        for (int i : arr) {
            a ^= i;
        }
        System.out.println(a);
    }
    public static void findTwoOddTimes(int[] arr) {
        if (arr == null || arr.length < 0) {
            System.out.println("数组不合法！");
        }
        int a = 0;
        for (int i : arr) {
            a ^= i;
        }
        System.out.println(a);
        int rightOne = a & (-a);
        int first = 0;
        for (int i : arr) {
            if((rightOne & i) ==0){
                first ^= i;
            }
        }
        System.out.println(a & (-a));
        System.out.println("first: " + first);
        System.out.println("second: " + (first ^ a));
    }

    public static void main(String[] args) {
        int[] ints = generateArray(6);
        System.out.println(Arrays.toString(ints));
        findOddTimes(ints);

        int[] arr = new int[ints.length + 1] ;
        int random = 0;
        do {
            random = (int) (Math.random() * 2000);
        } while (random < 1000);
        arr[ints.length] = random;
        System.arraycopy(ints, 0, arr, 0, ints.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(1 & -1);
        findTwoOddTimes(arr);
        System.out.println(8 & -8);

    }


    public static int[] generateArray(int nums) {
        int maxNum = 1000;
        if ((nums & 1) == 0) {
            nums++;
        }
        int arr[] = new int[nums];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                continue;
            }
            int random = 0;
            do {
                random = (int) (Math.random() * maxNum) - (int) (Math.random() * maxNum);
            } while (random == 0);
            if (size + 2 < nums) {

                int sencondIndex = 0;
                do {
                    sencondIndex = (int) (Math.random() * nums);
                } while (sencondIndex <= i || (i < nums - 1 && arr[sencondIndex] != 0));
                arr[sencondIndex] = random;
                System.out.println("random: " + random + " i: " + i + " sencondIndex: " + sencondIndex);
            } else {
                System.out.println(random);
            }
            arr[i] = random;
            size += 2;
        }
        return arr;
    }

}
