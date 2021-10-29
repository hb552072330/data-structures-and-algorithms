package cn.baymax.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2021/10/20
 */
public class CollectionsAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(-2);
            add(28);
            add(5);
            add(-8);
            add(-8);
            add(38);
        }};
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list, 0, list.size() - 1);
        System.out.println(list);
        System.out.println("------------");
        Collections.sort(list);
        System.out.println(list);
        Collections.rotate(list, 4);
        System.out.println(list);
        Collections.sort(list);
        System.out.println("------------");
        System.out.println(list);
        Collections.rotate(list, -3);
        System.out.println(list);
        System.out.println(Collections.max(list));
        //Collections.fill(list, 2);
        //System.out.println(list);
        System.out.println(Collections.frequency(list, -8));
        List<Integer> integers = Arrays.asList(38);
        System.out.println(Collections.indexOfSubList(list, integers));
        System.out.println(Collections.replaceAll(list, -8, -10));
        System.out.println(list);
    }
}
