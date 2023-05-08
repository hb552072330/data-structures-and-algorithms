package cn.baymax.mac01;

import java.util.*;

public class Code04_isStepSum {
    /**
     * 定义何为step sum？
     * 比如680，680 + 68 + 6 = 754，
     * 680的step sum叫754。
     * 给定一个正数num，判断它是不是某个数的step sum
     */

    //23  = x + x%10
    //21 + 2 = 23
    public static boolean isStepSumNumber(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int stepSum = stepSum(mid);
            if (stepSum < num) {
                l = mid + 1;
            } else if (stepSum > num) {
                r = mid - 1;
            } else {
                System.out.println(mid);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(stepSum(680));
        System.out.println(stepSum(12345));
        System.out.println(isStepSumNumber(60));
        System.out.println(isStepSumNumber(753));
        System.out.println(isStepSumNumber(811));
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int testNum = 1000;
        for (int i = 0; i < testNum; i++) {
            if(isStepSumNumber(i)){
                list.add(i);
            } else{
                list2.add(i);
            }
        }
        System.out.println(list);
        Map<Integer, Integer> stepNumMap = getStepNum(testNum);
        System.out.println("开始");
        Set<Integer> stepNumKeys = stepNumMap.keySet();
        for (Integer stepSum : list) {
            if (!stepNumKeys.contains(stepSum)) {
                System.out.println("出错了");
            }
        }
        for (Integer stepSum : list2) {
            if (stepNumKeys.contains(stepSum)) {
                System.out.println("出错了");
            }
        }
        System.out.println("结束");
    }

    public static Map<Integer, Integer> getStepNum(int maxStepNum){
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < maxStepNum; i++) {
            int sum = stepSum(i);
            if(sum > maxStepNum){
                break;
            }else{
                ans.put(sum, i);
            }
        }
        return ans;
    }

    private static int stepSum(int num) {
        int sum = num;
        num = num / 10;
        while (num > 0) {
            sum = sum + num;
            num = num / 10;
        }
        return sum;
    }
}
