package cn.baymax.base64;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

/**
 * 安全算列SHA
 * @author zhanghongbing
 * @data 2021/12/28
 */
public class SHADemo {

    private String SHA = "SHA";

    public void jdkSHA1() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
        byte[] digest = messageDigest.digest(SHA.getBytes());
        System.out.println("jdkSHA1:" + Hex.encodeHexString(digest));
    }

    public void jdkSHA256() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] digest = messageDigest.digest(SHA.getBytes());
        System.out.println("jdkSHA256:" + Hex.encodeHexString(digest));
    }

    public void jdkSHA384() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_384);
        byte[] digest = messageDigest.digest(SHA.getBytes());
        System.out.println("jdkSHA384:" + Hex.encodeHexString(digest));
    }

    public void jdkSHA512() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_512);
        byte[] digest = messageDigest.digest(SHA.getBytes());
        System.out.println("jdkSHA512:" + Hex.encodeHexString(digest));
    }

    public void bcSHA1() throws Exception {
        Digest digest = new SHA1Digest();
        digest.update(SHA.getBytes(), 0, SHA.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res, 0);
        System.out.println(" bcSHA1:" + Hex.encodeHexString(res));
    }

    public void bcSHA224() throws Exception {
        Digest digest = new SHA224Digest();
        digest.update(SHA.getBytes(), 0, SHA.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res, 0);
        System.out.println(" bcSHA224:" + Hex.encodeHexString(res));
    }
    public void addSHA224() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_224);
        byte[] digest = messageDigest.digest(SHA.getBytes());
        System.out.println("addSHA224:" + Hex.encodeHexString(digest));
    }

    public void bcSHA256() throws Exception {
        Digest digest = new SHA256Digest();
        digest.update(SHA.getBytes(), 0, SHA.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res, 0);
        System.out.println(" bcSHA256:" + Hex.encodeHexString(res));
    }

    public void bcSHA384() throws Exception {
        Digest digest = new SHA384Digest();
        digest.update(SHA.getBytes(), 0, SHA.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res, 0);
        System.out.println(" bcSHA384:" + Hex.encodeHexString(res));
    }

    public void bcSHA512() throws Exception {
        Digest digest = new SHA512Digest();
        digest.update(SHA.getBytes(), 0, SHA.getBytes().length);
        byte[] res = new byte[digest.getDigestSize()];
        digest.doFinal(res, 0);
        System.out.println(" bcSHA512:" + Hex.encodeHexString(res));
    }

    public void ccSHA512() throws Exception {
        System.out.println(" ccSHA512:" + DigestUtils.sha512Hex(SHA.getBytes()));
        System.out.println(" ccSHA512:" + DigestUtils.sha384Hex(SHA.getBytes()));
        System.out.println(" ccSHA512:" + DigestUtils.sha256Hex(SHA.getBytes()));
        System.out.println(" ccSHA512:" + DigestUtils.sha1Hex(SHA.getBytes()));
    }
}
