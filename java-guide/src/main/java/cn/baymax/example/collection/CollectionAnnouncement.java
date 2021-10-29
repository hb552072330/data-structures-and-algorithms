package cn.baymax.example.collection;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhanghongbing
 * @data 2021/10/25
 */
public class CollectionAnnouncement {

    public static void main(String[] args) {
        listToMap();
        System.out.println("--------------------");
        remove();
        System.out.println("--------------------");
        listToArray();
        System.out.println("--------------------");
        toList();
        System.out.println("--------------------");
        unModify();
        System.out.println("--------------------");
        toArrayMethod();
        System.out.println("--------------------");
        //参数不能为空
        List<String> il = ImmutableList.of("string", "elements");  // from varargs
        System.out.println(il);
        String[] aStringArray = {"string", "elements2"};
        il = ImmutableList.copyOf(aStringArray);      // from array
        System.out.println(il);
        System.out.println("--------------------");
        //可变集合
        List<String> l1 = Lists.newArrayList(il);    // from collection
        List<String> l2 = Lists.newArrayList(aStringArray);               // from array
        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println("--------------------");
        List<String> list = new ArrayList<String>();

        CollectionUtils.addAll(list, il);
        System.out.println("apache " + list);
    }

    private static void toArrayMethod() {
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(myList);
        myList.add(5);
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        myList.add(15);
        System.out.println(myList);
    }

    private static void unModify() {
        try {
            List myList = Arrays.asList(1, 2, 3);
            System.out.println(myList.getClass());
            myList.add(4);//运行时报错：UnsupportedOperationException
            myList.remove(1);//运行时报错：UnsupportedOperationException
            myList.clear();//运行时报错：UnsupportedOperationException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Arrays.asList()是泛型方法，传递的数组必须是对象数组，而不是基本类型。
    private static void toList() {
        try {
            int[] myArray = {5, 2, 3};
            List myList = Arrays.asList(myArray);
            System.out.println(myList.size());//1
            System.out.println(myList.get(0));//数组地址值
            //System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
            int[] array = (int[]) myList.get(0);
            System.out.println(array[0]);//1
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listToArray() {
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        //没有指定类型的话会报错
        s = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));
    }

    private static void remove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        System.out.println("list unremove : " + list);
        list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
        System.out.println(list); /* [1, 3, 5, 7, 9] */

    }

    // Set 去重代码示例
    //HashSet 的 contains() 方法底部依赖的 HashMap 的 containsKey() 方法，时间复杂度接近于 O（1）（没有出现哈希冲突的时候为 O（1））。
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        if (CollectionUtil.isEmpty(data)) {
            return new HashSet<>();
        }
        return new HashSet<>(data);
    }

    // List 去重代码示例
    //ArrayList 的 contains() 方法是通过遍历所有元素的方法来做的，时间复杂度接近是 O(n)。
    //我们的 List 有 N 个元素，那时间复杂度就接近是 O (n^2)。
    public static <T> List<T> removeDuplicateByList(List<T> data) {

        if (CollectionUtil.isEmpty(data)) {
            return new ArrayList<>();

        }
        List<T> result = new ArrayList<>(data.size());
        for (T current : data) {
            if (!result.contains(current)) {
                result.add(current);
            }
        }
        return result;
    }

    private static void listToMap() {
        try {
            //java.lang.NullPointerException
            //	at java.util.HashMap.merge(HashMap.java:1225)
            //
            List<Person> list = new ArrayList<Person>() {{
                add(new Person("张三", null));
                add(new Person("王五", 18));
                add(new Person("赵六", 21));
                add(new Person("李四", 7));
            }};
            System.out.printf("list is Empty %s \n", list.isEmpty());
            System.out.printf("list is Empty size %s \n", list.size() == 0);
            System.out.println();
            Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
            System.out.println(collect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
