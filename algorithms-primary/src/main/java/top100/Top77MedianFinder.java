package top100;

import java.util.PriorityQueue;

public class Top77MedianFinder {

    public Top77MedianFinder() {

    }
    PriorityQueue<Integer> min = new PriorityQueue<>();

    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) {
            max.offer(num);
        } else {
            min.offer(num);
        }
        blance();
    }

    private void blance() {
        if (Math.abs(max.size() - min.size()) > 1) {
            if (max.size() > min.size()) {
                min.offer(max.poll());
            } else {
                max.offer(min.poll());
            }
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (double) (max.peek() + min.peek()) / 2;
        } else {
            return max.size() > min.size() ? max.peek(): min.peek();
        }
    }

    public static void main(String[] args) {
        Top77MedianFinder finder = new Top77MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());

    }

}
