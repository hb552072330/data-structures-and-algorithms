package cn.baymax.topic;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/3/4
 */
public class Number20IsValidTest extends TestCase {

    public void testIsValid() {
        String s = "()[]{}";
        System.out.println(new Number20IsValid().isValid(s));
        s = "([)]";
        System.out.println(new Number20IsValid().isValid(s));
        s = "(]";
        System.out.println(new Number20IsValid().isValid(s));
        s = "{[]}";
        System.out.println(new Number20IsValid().isValid(s));
        s = "[]]]";
        System.out.println(new Number20IsValid().isValid(s));
    }
}