package cn.baymax.symmetric;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author zhanghongbing
 * @data 2021/12/31
 */
public class DESedeDemo {

    private static String DESede = "DESede";

    public void jdkDESede() throws Exception {
        //返回生成指定算法密钥的KeyGenerator对象
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        //初始化此密钥生成器，指定器密钥的大小
        keyGenerator.init(new SecureRandom());
        System.out.println(keyGenerator.getProvider().getInfo());
        //生成一个密钥
        SecretKey generateKey = keyGenerator.generateKey();
        byte[] keyEncoded = generateKey.getEncoded();
        System.out.println("keyEncoded:" + Hex.encodeHexString(keyEncoded));
        //转化密钥（还原密钥），将jdk生成的密钥转化成DES规则密钥对象
        //实例化DES密钥规则
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(keyEncoded);
        //实例化密钥工厂
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
        //生成一个密钥
        SecretKey convertSecretKey = factory.generateSecret(deSedeKeySpec);
        System.out.println("keyEncoded:" + Hex.encodeHexString(convertSecretKey.getEncoded()));
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

        byte[] bytes = cipher.doFinal(DESede.getBytes());
        System.out.println("jdkDESede encrypt:" + Hex.encodeHexString(bytes));
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] doFinal = cipher.doFinal(bytes);
        System.out.println("jdkDESede decrypt:" + new String(doFinal));
    }

    public void addDESede() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        //返回生成指定算法密钥的KeyGenerator对象
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede", "BC");
        System.out.println(keyGenerator.getProvider().getInfo());
        //初始化此密钥生成器，指定器密钥的大小
        keyGenerator.init(new SecureRandom());
        //生成一个密钥
        SecretKey generateKey = keyGenerator.generateKey();
        byte[] keyEncoded = generateKey.getEncoded();
        System.out.println("keyEncoded:" + Hex.encodeHexString(keyEncoded));
        //转化密钥（还原密钥），将jdk生成的密钥转化成DES规则密钥对象
        //实例化DES密钥规则
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(keyEncoded);
        //实例化密钥工厂
        String cipherAlgorithm = "DESede/ECB/PKCS5Padding";
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
        //生成一个密钥
        SecretKey convertSecretKey = factory.generateSecret(deSedeKeySpec);
        System.out.println("keyEncoded:" + Hex.encodeHexString(convertSecretKey.getEncoded()));
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

        byte[] bytes = cipher.doFinal(DESede.getBytes());
        System.out.println("addDESede encrypt:" + Hex.encodeHexString(bytes));
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] doFinal = cipher.doFinal(bytes);
        System.out.println("addDESede decrypt:" + new String(doFinal));
    }

}
