package cn.baymax.base64;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author zhanghongbing
 * @data 2021/12/21
 */
public class Base64DemoTest extends TestCase {

    Base64Demo base64Demo = new Base64Demo();
    public void testJDKBase64() throws IOException {
        base64Demo.jdkBase64();
        base64Demo.hutoolBase64();
        base64Demo.codecBase64();
        base64Demo.bouncycastleBase64();
    }
}