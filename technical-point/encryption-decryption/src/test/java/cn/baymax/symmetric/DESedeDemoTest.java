package cn.baymax.symmetric;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/31
 */
public class DESedeDemoTest extends TestCase {

    public void testJdkDESede() throws Exception {
        DESedeDemo demo = new DESedeDemo();
        demo.jdkDESede();
        demo.addDESede();
    }
}