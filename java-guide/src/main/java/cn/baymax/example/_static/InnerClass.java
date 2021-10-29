package cn.baymax.example._static;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//将Math中的所有静态资源导入，这时候可以直接使用里面的静态方法，而不用通过类名进行调用
//如果只想导入单一某个静态方法，只需要将*换成对应的方法名即可
import static java.lang.Math.*;//换成import static java.lang.Math.max;具有一样的效果
import static java.util.stream.Collectors.toSet;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class InnerClass {
    public InnerClass() {
        super();//该语句必须处于构造器的首行，否则编译器会报错。
        System.out.println("constructor");
    }

    public InnerClass(String str) {
        this();
        this.str = str;
    }

    public InnerClass(String str, String str2) {
        this(str2);
        this.str = str;
    }

    public static void main(String[] args) {
        InnerStatic innerStatic = new InnerStatic();
        innerStatic.test();
        InnerClass.Inner inner = new InnerClass().new Inner();
        inner.test();

        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(4);
        }};
        System.out.println("list" + list);
        Set<Integer> set = list.stream().collect(toSet());
        System.out.println("set" + set);
        System.out.println(max(2, 3));
    }

    private String str = " InnerClass String ";
    private static String staticStr = " InnerClass static String ";

    class Inner {
        public void test() {
            System.out.println(str + "inner test..");
            System.out.println(staticStr + "inner test..");
            String sss = this.ss;
            super.hashCode();
        }

        private String ss = "ss";
    }

    static class InnerStatic {
        public void test() {
            //System.out.println(str + "InnerStatic test..");//静态内部类特点1. 它的创建是不需要依赖外围类的创建。2. 它不能使用任何外围类的非 static 成员变量和方法。
            System.out.println(staticStr + "InnerStatic test..");
        }
    }
}
