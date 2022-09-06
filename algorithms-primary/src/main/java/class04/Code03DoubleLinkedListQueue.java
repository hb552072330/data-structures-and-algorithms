package class04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhanghongbing
 * @data 2022/9/2
 */
public class Code03DoubleLinkedListQueue {
    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v) {
            value = v;
            last = null;
            next = null;
        }
    }

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

        public void pushHead(V v) {
            Node<V> cur = new Node<>(v);
            if (head != null) {
                cur.next = head;
                head.last = cur;
                head = cur;
            } else {
                head = cur;
                tail = cur;
            }
            size++;
        }

        public void pushTail(V v) {
            Node<V> cur = new Node<>(v);
            if (tail != null) {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            } else {
                head = cur;
                tail = cur;
            }
            size++;
        }

        public V pollHead() {
            if (head == null) {
                return null;
            }
            V ans = null;
            size--;
            ans = head.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public V pollTail() {
            if (tail == null) {
                return null;
            }
            V ans = null;
            size--;
            ans = tail.value;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }
    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Deque<Integer> deque = new LinkedList<>();
        int testTime = 500000;
        int maxValue = 20000000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != deque.isEmpty()) {
                System.out.println("Ooops");
            }
            if (myQueue.size() != deque.size()) {
                System.out.println("Ooops");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                if (Math.random() < 0.5) {
                    myQueue.pushHead(num);
                    deque.addFirst(num);
                } else {
                    myQueue.pushTail(num);
                    deque.addLast(num);
                }
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int myNum = 0;
                    int dNum = 0;
                    if (Math.random() < 0.5) {
                        myNum = myQueue.pollHead();
                        dNum = deque.pollFirst();
                    } else {
                        myNum = myQueue.pollTail();
                        dNum = deque.pollLast();
                    }
                    if (myNum != dNum) {
                        System.out.println("Ooops");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int myNum = 0;
                    int dNum = 0;
                    if (Math.random() < 0.5) {
                        myNum = myQueue.peekHead();
                        dNum = deque.peekFirst();
                    } else {
                        myNum = myQueue.peekTail();
                        dNum = deque.peekLast();
                    }
                    if (myNum != dNum) {
                        System.out.println("Ooops");
                    }
                }
            }
        }
        if (deque.size() != myQueue.size()) {
            System.out.println("Oops");
        }
        while (!myQueue.isEmpty()) {
            int myNum = 0;
            int dNum = 0;
            if (Math.random() < 0.5) {
                myNum = myQueue.pollHead();
                dNum = deque.pollFirst();
            } else {
                myNum = myQueue.pollTail();
                dNum = deque.pollLast();
            }
            if (myNum != dNum) {
                System.out.println("Ooops");
            }
        }
        System.out.println("test end");
    }

    public static void main(String[] args) {
        testQueue();
    }
}
