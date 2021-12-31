package cn.baymax.base64;


import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 消息认证码SHA
 *
 * @author zhanghongbing
 * @data 2021/12/28
 */
public class MACDemo {

    private String MAC = "mac";

    public void jdkHmacMD5() throws Exception {
        //初始化KeyGenerator
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        //生成密钥
        //SecretKey secretKey = keyGenerator.generateKey();
        //自定义密钥
        byte[] key = Hex.decodeHex("aa".toCharArray());
        //还原密钥
        SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
        System.out.println("secretKey:" + Hex.encodeHexString(secretKey.getEncoded()));
        System.out.println("getAlgorithm:" + secretKey.getAlgorithm());
        //实例化MAC
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        //初始化MAC
        mac.init(secretKey);
        //执行摘要
        byte[] bytes = mac.doFinal(MAC.getBytes());
        System.out.println("jdkHmacMD5:" + Hex.encodeHexString(bytes));
    }

    public void jdkHmacSHA1() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
        //SecretKey secretKey = keyGenerator.generateKey();
        byte[] key = Hex.decodeHex("aa".toCharArray());
        SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
        System.out.println("secretKey:" + Hex.encodeHexString(secretKey.getEncoded()));
        System.out.println("getAlgorithm:" + secretKey.getAlgorithm());
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] bytes = mac.doFinal(MAC.getBytes());
        System.out.println("jdkHmacSHA1:" + Hex.encodeHexString(bytes));
    }


    public void bcHmacMD5() throws Exception {
        HMac hMac = new HMac(new MD5Digest());
        System.out.println("getAlgorithmName:" + hMac.getAlgorithmName());
        hMac.init(new KeyParameter(Hex.decodeHex("aa")));
        hMac.update(MAC.getBytes(), 0, MAC.getBytes().length);
        byte[] bytes = new byte[hMac.getMacSize()];
        //执行摘要
        hMac.doFinal(bytes, 0);
        System.out.println(" bcHmacMD5:" + Hex.encodeHexString(bytes));
    }

    public void bcHmacSHA1() throws Exception {
        HMac hMac = new HMac(new SHA1Digest());
        System.out.println("getAlgorithmName:" + hMac.getAlgorithmName());
        hMac.init(new KeyParameter(Hex.decodeHex("aa")));
        hMac.update(MAC.getBytes(), 0, MAC.getBytes().length);
        byte[] bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(bytes, 0);
        System.out.println(" bcHmacSHA1:" + Hex.encodeHexString(bytes));
    }
    public void bcHmacMD2() throws Exception {
        HMac hMac = new HMac(new MD2Digest());
        System.out.println("getAlgorithmName:" + hMac.getAlgorithmName());
        hMac.init(new KeyParameter(Hex.decodeHex("aa")));
        hMac.update(MAC.getBytes(), 0, MAC.getBytes().length);
        byte[] bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(bytes, 0);
        System.out.println(" bcHmacMD2:" + Hex.encodeHexString(bytes));
    }
}
