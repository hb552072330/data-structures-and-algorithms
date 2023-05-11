package cn.baymax.mac02;

import java.util.PriorityQueue;

public class Code02_LessMoneySplitGold {
    /**
     * 哈夫曼树 -> 分金条问题
     * [10, 20, 30] 最小代价 90
     * 60  分 30  30 ； 30 分 20 10
     */
    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : arr) {
            priorityQueue.add(i);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            int current = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(current);
            sum += current;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {20, 10, 30};
        System.out.println(lessMoney(arr));
    }
}
