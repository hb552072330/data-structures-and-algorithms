package top100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Top75FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }
        while (--k > 0) {
            swap(nums, 0, --len);
            heapify(nums, 0, len);
        }

        return nums[0];
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int lagerst = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            lagerst = arr[lagerst] > arr[index] ? lagerst : index;
            if (lagerst == index) {
                break;
            }
            swap(arr, lagerst, index);
            index = lagerst;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int lagerst, int index) {
        int tmp = arr[lagerst];
        arr[lagerst] = arr[index];
        arr[index] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {

            heapify(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
    }


    public int findKthLargest3(int[] nums, int k) {

        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        int ans = 0;
        while (!queue.isEmpty() && k > 0) {
            ans = queue.poll();
            k--;
        }

        return ans;
    }
}
