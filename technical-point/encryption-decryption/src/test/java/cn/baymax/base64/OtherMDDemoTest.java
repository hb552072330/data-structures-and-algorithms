package cn.baymax.base64;

import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2021/12/30
 */
public class OtherMDDemoTest extends TestCase {

    public void testBcTiger() {
        OtherMDDemo otherMDDemo = new OtherMDDemo();
        otherMDDemo.bcTiger();
        otherMDDemo.bcGOST3411();
        otherMDDemo.bcWhirlpoolDigest();
    }
}