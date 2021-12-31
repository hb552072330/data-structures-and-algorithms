package cn.baymax.base64;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/28
 */
public class MACDemoTest extends TestCase {

    public void testJdkHmacMD5() throws Exception {
        MACDemo macDemo = new MACDemo();
        macDemo.jdkHmacMD5();
        macDemo.bcHmacMD5();
        macDemo.bcHmacMD2();
        //macDemo.jdkHmac("HmacMD2");
        macDemo.jdkHmacSHA1();
        macDemo.bcHmacSHA1();
    }
}