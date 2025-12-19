package cn.baymax.mac06;

import java.io.Serializable;

public class TestClone {
    public static class User implements Serializable, Cloneable {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        protected static User createUser(User user) {
            return (User) user.clone();
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
        public User clone()
        {
            User worker = null;
            try {
                return (User) super.clone();
            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return worker;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        User user = new User("张三", 12);
        System.out.println(user + " hashcode " + user.hashCode());
        User clone = User.createUser(user);
        System.out.println(clone + " hashcode " + clone.hashCode());
    }
}
