package cn.baymax.mac05;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/lru-cache/
//146
public class Code05_LRUCache {
    public class LRUCache {

        class Node {
            int key;
            int val;
            Node last;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class DoubleLinkedList {
            Node head;
            Node tail;

            public void addNode(Node newNode) {
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }
            }

            public void moveNoedToTail(Node node) {
                if (node == tail) {
                    return;
                } else if (node.last == null) {
                    head = node.next;
                    head.last = null;
                } else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                node.last = tail;
                tail.next = node;
                node.next = null;
                tail = node;
            }

            public Node removeHead() {
                if (head == null) {
                    return null;
                }
                Node ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.last = null;
                    ans.next = null;
                }
                return ans;
            }
        }

        private final int capacity;


        private DoubleLinkedList doubleLinkedList;

        Map<Integer, Node> keyMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            doubleLinkedList = new DoubleLinkedList();
            keyMap = new HashMap<>();
        }

        public int get(int key) {
            if (keyMap.containsKey(key)) {
                Node ans = keyMap.get(key);
                doubleLinkedList.moveNoedToTail(ans);
                return ans.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (keyMap.containsKey(key)) {
                Node node = keyMap.get(key);
                node.val = value;
                doubleLinkedList.moveNoedToTail(node);

            } else {
                if (keyMap.size() == capacity) {
                    removeUnusedCache();
                }
                Node newNode = new Node(key, value);
                doubleLinkedList.addNode(newNode);
                keyMap.put(key, newNode);
            }

        }

        private void removeUnusedCache() {
            Node head = doubleLinkedList.removeHead();
            keyMap.remove(head.key);
        }
    }
}
