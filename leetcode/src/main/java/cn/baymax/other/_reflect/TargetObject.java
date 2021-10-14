package cn.baymax.other._reflect;

/**
 * @author zhanghongbing
 * @data 2021/10/14
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "java";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
