package cn.baymax.digest;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/27
 */
public class MDDemoTest extends TestCase {

    public void testJdkMD5() throws Exception {
        MDDemo mdDemo = new MDDemo();
        mdDemo.jdkMD5();
        mdDemo.bcMD5();
        mdDemo.ccMD5();
        mdDemo.jdkMD2();
        mdDemo.bcMD2();
        mdDemo.ccMD2();
        mdDemo.bcMD4();
        mdDemo.addMD4();
    }
}

