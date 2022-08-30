package class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author zhanghongbing
 * @data 2022/8/30
 */
public class Code05HashMapTreeMap {
    public static class Node implements Comparable {
        public int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("zhangsan", "我是张三");
        System.out.println(hMap.containsKey("zhangsan"));
        System.out.println(hMap.containsKey("zhang"));
        System.out.println(hMap.get("zhangsan"));

        hMap.put("zhangsan", "他是张三");
        System.out.println(hMap.get("zhangsan"));
        String test1 = new String("zhangsan");
        String test2 = new String("zhangsan");
        System.out.println(hMap.get(test1));
        System.out.println(hMap.get(test2));

        HashMap<Integer, String> hMap2 = new HashMap<>();
        hMap2.put(123456, "我是123456");
        Integer a = 123456;
        Integer b = 123456;
        System.out.println(a == b);
        System.out.println(hMap2.containsKey(a));
        System.out.println(hMap2.containsKey(b));

        HashMap<Node, String> hMap3 = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        hMap3.put(node1, "我是node1");
        System.out.println(hMap3.containsKey(node1));
        System.out.println(hMap3.containsKey(node2));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(1, "我是3");
        treeMap1.put(4, "我是3");
        treeMap1.put(9, "我是3");
        treeMap1.put(2, "我是3");
        treeMap1.put(7, "我是3");
        treeMap1.put(11, "我是3");
        System.out.println(treeMap1.containsKey(1));
        System.out.println(treeMap1.containsKey(6));
        System.out.println(treeMap1.get(4));
        treeMap1.remove(4);
        System.out.println(treeMap1.get(4));

        System.out.println(treeMap1.firstKey());
        System.out.println(treeMap1.lastKey());
        System.out.println(treeMap1.floorKey(3));
        System.out.println(treeMap1.floorKey(6));
        System.out.println(treeMap1.ceilingKey(3));
        System.out.println(treeMap1.ceilingKey(7));

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        TreeMap<Node, String> treeMap2 = new TreeMap<Node, String>();
        treeMap2.put(node3, "我是node3");
        treeMap2.put(node4, "我是node4");
    }
}
