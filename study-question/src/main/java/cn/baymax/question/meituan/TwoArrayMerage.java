package cn.baymax.question.meituan;

import java.util.Arrays;

/**
 * @author zhanghongbing
 * @data 2021/6/30
 */
public class TwoArrayMerage {
    //比如将如下两个有序数组
    //
    //[1, 3, 5, 7, 9, 12, 15, 18] 和 [2, 8, 11, 16, 19] 排序后，我们希望得到新数组[ 1, 2, 3, 5, 7, 8, 9, 11, 12, 15, 16, 18, 19 ]
    //
    //
    //提示：不能java的原生排序、工具类
    public static void main(String[] args) {
        int[] firstArr = {1, 3, 5, 7, 9, 12, 15, 18};
        int[] secondArr = {2, 8, 11, 16, 19};
        System.out.println(Arrays.toString(merage(firstArr, secondArr)));
    }

    private static int[] merage(int[] firstArr, int[] secondArr) {
        int length = firstArr.length + secondArr.length;
        int[] result = new int[length];
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < length; i++) {
            if (firstArr.length > firstIndex && secondArr.length > secondIndex) {
                if (firstArr[firstIndex] < secondArr[secondIndex]) {
                    result[i] = firstArr[firstIndex++];
                } else {
                    result[i] = secondArr[secondIndex++];
                }
            } else if (firstArr.length <= firstIndex && secondArr.length > secondIndex) {
                result[i] = secondArr[secondIndex++];
            } else if (firstArr.length > firstIndex && secondArr.length <= secondIndex) {
                result[i] = firstArr[firstIndex++];
            } else {
                break;
            }
        }
        return result;
    }

}
