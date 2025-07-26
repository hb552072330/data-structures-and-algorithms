package top100;

import java.util.HashMap;
import java.util.Map;

public class Top36LRUCache {


    public Top36LRUCache(int capacity) {
        this.cache = new MyCache<>(capacity);
    }

    private int capacity;
    private static MyCache<Integer, Integer> cache;

    public int get(int key) {
        Integer ans = cache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        cache.set(key, value);
    }


    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> keyMap;
        private NodeLinkList<K, V> nodeList;
        private final int capacity;

        public MyCache(int capacity) {
            this.capacity = capacity;
            this.keyMap = new HashMap<>((capacity << 2) / 3);
            this.nodeList = new NodeLinkList<K, V>();
        }

        public V get(K key) {
            if (!keyMap.containsKey(key)) {
                return null;
            }
            Node<K, V> kvNode = keyMap.get(key);
            nodeList.moveToTail(kvNode);
            return kvNode.value;
        }

        public void set(K key, V value) {
            if (keyMap.containsKey(key)) {
                Node<K, V> kvNode = keyMap.get(key);
                kvNode.value = value;
                nodeList.moveToTail(kvNode);
            } else {
                Node<K, V> newNode = new Node<>(key, value);
                keyMap.put(key, newNode);
                nodeList.addNode(newNode);
                if (keyMap.size() == capacity + 1) {
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> kvNode = nodeList.removeHead();
            keyMap.remove(kvNode.key);
        }
    }

    public static class NodeLinkList<K, V> {
        public Node<K, V> tail;
        public Node<K, V> head;

        public NodeLinkList() {
            this.tail = null;
            this.head = null;
        }

        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }

        public void moveToTail(Node<K, V> node) {
            if (node == null || node == tail) {
                return;
            }
            if (node == head) {
                head = head.next;
                head.last = null;
            } else {
//                Node<K, V> next = node.next;
//                Node<K, V> last = node.last;
//                last.next = next;
//                next.last = last;
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        public Node<K, V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<K, V> res = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                res.next = null;
                head.last = null;
            }
            return res;
        }
    }

    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> last;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
