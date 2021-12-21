package cn.baymax.base64;


import cn.hutool.core.codec.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author zhanghongbing
 * @data 2021/12/21
 */
public class Base64Demo {

    private String data = "base64";

    public void jdkBase64() throws IOException {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(data.getBytes());
        System.out.printf("JDKBase64 base64Encoder : %s \r\n", encode);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        System.out.printf("JDKBase64 base64Encoder : %s \r\n", new String(bytes));
    }

    /**
     * 对jdk做了封装
     */
    public void hutoolBase64() {
        String encode = Base64.encode(data.getBytes());
        byte[] decode = Base64.decode(encode.getBytes());
        System.out.printf("hutoolBase64 base64Encoder : %s \r\n", encode);
        System.out.printf("hutoolBase64 base64Encoder : %s \r\n", new String(decode));
    }

    public void codecBase64() {
        byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(data.getBytes());
        byte[] decodeBase64 = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBase64);
        System.out.printf("codecBase64 base64Encoder : %s \r\n", new String(encodeBase64));
        System.out.printf("codecBase64 base64Encoder : %s \r\n", new String(decodeBase64));
    }

    public void bouncycastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(data.getBytes());
        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.printf("bouncycastleBase64 base64Encoder : %s \r\n", new String(encode));
        System.out.printf("bouncycastleBase64 base64Encoder : %s \r\n", new String(decode));
    }
}
