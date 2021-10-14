package cn.baymax.other._static;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class StaticBean {
    public StaticBean() {
    }

    String name;
    //静态变量
    static int age;

    public StaticBean(String name) {
        this.name = name;
        System.out.println("构造");
    }

    //静态方法
    static void sayHello() {
        System.out.println("Hello i am java");
    }

    @Override
    public String toString() {
        return "StaticBean{" +
                "name=" + name + ",age=" + age +
                "}";
    }

    public static void main(String[] args) {
        StaticBean staticBean = new StaticBean("1");
        StaticBean staticBean2 = new StaticBean("2");
        StaticBean staticBean3 = new StaticBean("3");
        StaticBean staticBean4 = new StaticBean("4");
        StaticBean.age = 33;
        System.out.println(staticBean + " " + staticBean2 + " " + staticBean3 + " " + staticBean4);
        //StaticBean{name=1,age=33} StaticBean{name=2,age=33} StaticBean{name=3,age=33} StaticBean{name=4,age=33}
        StaticBean.sayHello();//Hello i am java
        System.out.println(StaticBean.i);
    }
    {
        System.out.println("非静态");
    }

    static {//静态代码块在非静态代码块之前执行(静态代码块 —> 非静态代码块 —> 构造方法)
        System.out.println("静态");
        i = 10;
        //System.out.println(i);//静态代码块对于定义在它之后的静态变量，可以赋值，但是不能访问
    }
    static int i = 1;
}
