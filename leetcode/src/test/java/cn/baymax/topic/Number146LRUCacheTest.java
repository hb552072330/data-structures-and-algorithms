package cn.baymax.topic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author zhanghongbing
 * @data 2021/6/23
 */
public class Number146LRUCacheTest extends TestCase {

    @Test
    public void test() {
        Number146LRUCache lruCache = new Number146LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    @Test
    public void testLRUCache() {
        Number146LRUCache lruCache = new Number146LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6, 11);
        lruCache.put(10, 5);
        lruCache.put(9, 10);
        System.out.println(lruCache.get(13));
        lruCache.put(2, 19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5, 25);
        System.out.println(lruCache.get(8));
        lruCache.put(9, 22);
        lruCache.put(5, 5);
        lruCache.put(1, 30);
        System.out.println(lruCache.get(11));
        lruCache.put(9, 12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4, 30);
        lruCache.put(9, 3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
        lruCache.put(6, 14);
        lruCache.put(3, 1);
        System.out.println(lruCache.get(3));
        lruCache.put(10, 11);
        System.out.println(lruCache.get(8));
        lruCache.put(2, 14);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(5));

    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.addFirst(4);
        System.out.println(list);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);
        System.out.println(list2);
        list2.addFirst(4);
        System.out.println(list2);
        list.remove();
        System.out.println(list);
        list2.remove();
        System.out.println(list2);
        LinkedHashMap map = new LinkedHashMap(3, 0.75f, true);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map);
        map.get(2);
        map.put(2, 22);
        System.out.println(map);
        map.put(4, 4);
        System.out.println(map);

    }

}