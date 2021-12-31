package cn.baymax.digest;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/28
 */
public class SHADemoTest extends TestCase {

    public void testJdkSHA1() throws Exception {
        SHADemo shaDemo = new SHADemo();
        shaDemo.jdkSHA1();
        shaDemo.bcSHA1();
        shaDemo.bcSHA224();
        shaDemo.addSHA224();
        shaDemo.jdkSHA256();
        shaDemo.bcSHA256();
        shaDemo.jdkSHA384();
        shaDemo.bcSHA384();
        shaDemo.jdkSHA512();
        shaDemo.bcSHA512();
        shaDemo.ccSHA512();
        System.out.println(System.currentTimeMillis());
    }
}