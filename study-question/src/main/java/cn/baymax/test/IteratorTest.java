package cn.baymax.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2022/1/22
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("test");
            add("delete");
            add("add");
            add("test");
            add("update");
            add("test");
        }};
        Iterator<String> iterator = list.iterator();
        System.out.println(list);
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("test".equals(next)) {
                continue;
            } else {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
