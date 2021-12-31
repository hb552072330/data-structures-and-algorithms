package cn.baymax.base64;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

/**
 * 消息摘要MD
 * @author zhanghongbing
 * @data 2021/12/27
 */
public class MDDemo {
    public static final String MD = "MD";

    public void jdkMD5() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] digest = messageDigest.digest(MD.getBytes());
        System.out.println("jdkMD5:" + Hex.encodeHexString(digest));
    }

    public void jdkMD2() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD2);
        byte[] digest = messageDigest.digest(MD.getBytes());
        System.out.println("jdkMD2:" + Hex.encodeHexString(digest));
    }


    public void bcMD5() throws Exception {
        Digest digest = new MD5Digest();
        digest.update(MD.getBytes(), 0, MD.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res,0);
        System.out.println(" bcMD5:" + Hex.encodeHexString(res));
    }


    public void bcMD2() throws Exception {
        Digest digest = new MD2Digest();
        digest.update(MD.getBytes(), 0, MD.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res,0);
        System.out.println(" bcMD2:" + Hex.encodeHexString(res));
    }

    public void bcMD4() throws Exception {
        Digest digest = new MD4Digest();
        digest.update(MD.getBytes(), 0, MD.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res,0);
        System.out.println(" bcMD4:" + Hex.encodeHexString(res));
    }

    public void addMD4() throws Exception{
        //给JDK动态添加摘要算法provider
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest messageDigest = MessageDigest.getInstance("MD4");
        byte[] digest = messageDigest.digest(MD.getBytes());
        //加密后得到byte[]需要用 Hex.encodeHexString 转换成16进制显示 字符串
        System.out.println("addMD4:" + Hex.encodeHexString(digest));
    }

    public void ccMD5() throws Exception{
        System.out.println(" ccMD5:" + DigestUtils.md5Hex(MD.getBytes()));
    }

    public void ccMD2() throws Exception{
        System.out.println(" ccMD2:" + DigestUtils.md2Hex(MD.getBytes()));
    }

}
