package cn.baymax.mac02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Code03_MinimumCostToHireKWorkers {
    //输入： quality = [10,20,5], wage = [70,50,30], k = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
//
// 示例 2：
//
//
//输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        Code03_MinimumCostToHireKWorkers workers = new Code03_MinimumCostToHireKWorkers();
        System.out.println(workers.mincostToHireWorkers(quality, wage, 2));
        int[] quality2 = {3, 1, 10, 10, 1};
        int[] wage2 = {4, 8, 2, 2, 7};
        System.out.println(workers.mincostToHireWorkers(quality2, wage2, 3));
    }

    //[14,56,59,89,39,26,86,76,3,36]
    //[90,217,301,202,294,445,473,245,415,487]
    //			2
    //	测试结果:511.50000
    //	期望结果:399.53846

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans = Double.MAX_VALUE;
        if (quality.length != wage.length) {
            return 0;
        }
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }
        Arrays.sort(workers, (w1, w2) -> w1.cost <= w2.cost ? -1 : 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int qualitySum = 0;
        for (int i = 0; i < workers.length; i++) {
            if (queue.size() < k) {
                qualitySum += workers[i].quality;
                queue.add(workers[i].quality);
                if (queue.size() == k) {
                    ans = Math.min(ans, workers[i].cost * qualitySum);
                }
            } else {
                int currentQuality = workers[i].quality;
                if (queue.peek() > currentQuality) {
                    qualitySum = currentQuality - queue.poll() + qualitySum;

                    queue.add(currentQuality);
                    ans = Math.min(ans, workers[i].cost * qualitySum);
                }
            }
        }
        return ans;
    }


    public static class Worker {
        public double cost;
        public int quality;

        public Worker(int wage, int quality) {
            this.cost = (double) wage / (double) quality;
            this.quality = quality;
        }
    }

}
