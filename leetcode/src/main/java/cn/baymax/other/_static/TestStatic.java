package cn.baymax.other._static;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class TestStatic {
    public TestStatic() {
        System.out.print("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块！--");
    }

    //静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    private static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }

    public static void main(String[] args) {
        TestStatic test = new TestStatic();
        //TestStatic.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--
    }
}
