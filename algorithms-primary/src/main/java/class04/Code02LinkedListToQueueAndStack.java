package class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhanghongbing
 * @data 2022/8/31
 */
public class Code02LinkedListToQueueAndStack {
    public static class Node<V> {
        V val;
        Node next;

        Node() {
        }

        Node(V val) {
            this.val = val;
        }

        Node(V val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //head 反转链表
    //pre = null
    //next = head.next;
    //head.next = pre;
    //pre = head;
    //head = next
    public static class MyQueue<V> {

        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(V value) {
            Node<V> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.val;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.val;
            }
            return ans;
        }

    }

    public static class MyStack<V> {
        Node<V> head;
        int size;

        public MyStack() {
        }

        public boolean isEmpty() {
            return 0 == size;
        }

        public int size() {
            return size;
        }

        public void push(V v) {
            Node<V> cur = new Node<V>(v);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.val;
                head = head.next;
                size--;
            }
            return ans;
        }

        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.val;
            }
            return ans;
        }

    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        int testTimes = 5000000;
        int maxValue = 200000000;
        System.out.println("test begin!!!");
        for (int i = 0; i < testTimes; i++) {
            if (myQueue.size() != queue.size()) {
                System.out.println("Oops");
            }
            if (myQueue.isEmpty() != queue.isEmpty()) {
                System.out.println("Oops");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                queue.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    Integer myNum = myQueue.poll();
                    Integer num = queue.poll();
                    if (myNum.intValue() != num.intValue()) {
                        System.out.println("Oops");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    Integer myNum = myQueue.peek();
                    Integer num = queue.peek();
                    if (myNum.intValue() != num.intValue()) {
                        System.out.println("Oops");
                    }
                }
            }
            if (myQueue.size() != queue.size()) {
                System.out.println("Oops");
            }
            while (!myQueue.isEmpty()) {
                Integer myNum = myQueue.poll();
                Integer num = queue.poll();
                if (myNum.intValue() != num.intValue()) {
                    System.out.println("Oops");
                }
            }

        }
        System.out.println("test end!!!!");
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> stack = new Stack<>();
        int testTimes = 5000000;
        int maxValue = 200000000;
        System.out.println("test begin!!!");
        for (int i = 0; i < testTimes; i++) {
            if (myStack.isEmpty() != stack.isEmpty()) {
                System.out.println("Oops");
            }
            if (myStack.size() != stack.size()) {
                System.out.println("Oops");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                stack.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    Integer myNum = myStack.pop();
                    Integer num = stack.pop();
                    if (num.intValue() != myNum.intValue()) {
                        System.out.println("Oops");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    Integer myNum = myStack.peek();
                    Integer num = stack.peek();
                    if (num.intValue() != myNum.intValue()) {
                        System.out.println("Oops");
                    }
                }
            }
        }
        if (myStack.size() != stack.size()) {
            System.out.println("Oops");
        }
        while (!myStack.isEmpty()) {
            Integer myNum = myStack.pop();
            Integer num = stack.pop();
            if (num.intValue() != myNum.intValue()) {
                System.out.println("Oops");
            }
        }
        System.out.println("test end!!!");
    }

    public static void main(String[] args) {
        testQueue();
        testStack();
    }
    /*class MyStack {

        public MyStack() {

        }

        public void push(int x) {

        }

        public int pop() {

        }

        public int top() {

        }

        public boolean empty() {

        }
    }*/
}
