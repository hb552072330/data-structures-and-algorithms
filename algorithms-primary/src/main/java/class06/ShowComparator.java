package class06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhanghongbing
 * @data 2022/9/22
 */
public class ShowComparator {

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

        //如果返回负数，认为第一个参数应该排在前面
        //如果返回正数，认为第二个参数应该排在前面
        //如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class AgeComparator implements Comparator<Student> {

        //如果返回负数，认为第一个参数应该排在前面
        //如果返回正数，认为第二个参数应该排在前面
        //如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.name + ", " + student.age + ", " + student.id);
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 5, 9, 0, 3, 1, 4, 2, 0};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        Student s1 = new Student("张三", 5, 12);
        Student s2 = new Student("李四", 1, 23);
        Student s3 = new Student("王五", 15, 29);
        Student s4 = new Student("赵六", 6, 9);
        Student s5 = new Student("左七", 2, 42);
        Student[] students = {s1, s2, s3, s4, s5};
        printStudents(students);
        System.out.println("============");
        Arrays.sort(students, new ShowComparator.AgeComparator());
        printStudents(students);
        System.out.println("============");
        List<Student> list = new ArrayList<Student>() {{
            add(s1);
            add(s2);
            add(s3);
            add(s4);
            add(s5);
        }};
        for (Student student : list) {
            System.out.println(student.name + ", " + student.age + ", " + student.id);
        }
        System.out.println("============");
        list.sort(new IdComparator());
        for (Student student : list) {
            System.out.println(student.name + ", " + student.age + ", " + student.id);
        }

    }
}
