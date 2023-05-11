package cn.baymax.symmetric;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/31
 */
public class DESDemoTest extends TestCase {

    public void testJdkDES() throws Exception {
        DESDemo desDemo = new DESDemo();
        desDemo.jdkDES();
        desDemo.bcDES();
    }
}