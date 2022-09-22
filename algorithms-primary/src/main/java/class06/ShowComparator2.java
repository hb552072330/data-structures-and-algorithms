package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanghongbing
 * @data 2022/9/22
 */
public class ShowComparator2 {
    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class Student {
        public String name;
        public int age;
        public int id;

        public Student(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }

    public static class IdComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

        public static void main(String[] args) {
            String str = "abc";
            String str2 = "b";
            System.out.println(str.compareTo(str2));
            PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
            Student s1 = new Student("张三", 5, 12);
            Student s2 = new Student("李四", 1, 23);
            Student s3 = new Student("王五", 15, 29);
            Student s4 = new Student("赵六", 6, 9);
            Student s5 = new Student("左七", 2, 42);
            heap.add(s1);
            heap.add(s2);
            heap.add(s3);
            heap.add(s4);
            heap.add(s5);
            System.out.println("----------");
            while (!heap.isEmpty()) {
                Student student = heap.poll();
                System.out.println(student.name + ", " + student.age + ", " + student.id);
            }
        }
    }
}
