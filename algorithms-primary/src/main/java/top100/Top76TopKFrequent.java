package top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top76TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.count - b.count);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new Node(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        int idx = 0;
        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll().num;
        }
        return ans;
    }

    public static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
