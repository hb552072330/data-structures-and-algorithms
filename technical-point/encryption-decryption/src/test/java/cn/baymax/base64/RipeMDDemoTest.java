package cn.baymax.base64;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/30
 */
public class RipeMDDemoTest extends TestCase {

    private RipeMDDemo ripeMDDemo = new RipeMDDemo();

    public void testBcRipeMD128() {
        ripeMDDemo.bcRipeMD128();
        ripeMDDemo.bcRipeMD160();
        ripeMDDemo.bcRipeMD256();
    }
}