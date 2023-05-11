package cn.baymax.mac02;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Code01_CoverMax {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(12);
        queue.offer(21);
        queue.offer(44);
        queue.offer(222);
        queue.offer(131);
        queue.offer(12);
        queue.offer(-12);
        queue.offer(31);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        int[][] lines = new int[4][2];
        lines[0][0] = 5;
        lines[0][1] = 7;
        lines[1][0] = 5;
        lines[1][1] = 6;
        lines[2][0] = 1;
        lines[2][1] = 5;
        lines[3][0] = 8;
        lines[3][1] = 9;
        for (int[] line : lines) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("----");
        System.out.println(getCoverMax(lines));

    }

    /**
     * 最大线段重合问题
     */
    public static int getCoverMax(int[][] lines){
        // m = [ [4, 7], [3, 6], [1, 5] , [2, 9] ]
        // 开始位置排序！
        // m = [ [1, 5], [2, 9], [3, 6] , [4, 7] ]
        Arrays.sort(lines, (a, b)-> a[0] -b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        for (int[] line : lines) {
            System.out.println(Arrays.toString(line));
            while(!queue.isEmpty() && queue.peek() <= line[0]){
                queue.poll();
            }
            queue.add(line[1]);
            max= Math.max(max, queue.size());
        }
        return max;
    }

}
