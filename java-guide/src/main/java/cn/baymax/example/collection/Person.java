package cn.baymax.example.collection;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author zhanghongbing
 * @data 2021/10/20
 */
public class Person {
    private String name;
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>((person1, person2) -> {
            int num = person1.getAge() - person2.getAge();
            return Integer.compare(num, 0);
        });
        treeMap.put(new Person(3), "person1");
        treeMap.put(new Person(18), "person2");
        treeMap.put(new Person(35), "person3");
        treeMap.put(new Person(16), "person4");
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
    }

}
