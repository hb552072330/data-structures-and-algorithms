package cn.baymax.symmetric;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.generators.DESKeyGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author zhanghongbing
 * @data 2021/12/31
 */
public class DESDemo {

    private static String DES = "des";

    public void jdkDES() throws Exception {
        //返回生成指定算法密钥的KeyGenerator对象
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        //初始化此密钥生成器，指定器密钥的大小
        keyGenerator.init(56);
        System.out.println(keyGenerator.getProvider().getInfo());
        //生成一个密钥
        SecretKey generateKey = keyGenerator.generateKey();
        byte[] keyEncoded = generateKey.getEncoded();
        System.out.println("keyEncoded:" + Hex.encodeHexString(keyEncoded));
        //转化密钥（还原密钥），将jdk生成的密钥转化成DES规则密钥对象
        //实例化DES密钥规则
        DESKeySpec deSedeKeySpec = new DESKeySpec(keyEncoded);
        //实例化密钥工厂
        String cipherAlgorithm = "DES/ECB/PKCS5Padding";
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        //生成一个密钥
        SecretKey convertSecretKey = factory.generateSecret(deSedeKeySpec);
        System.out.println("keyEncoded:" + Hex.encodeHexString(convertSecretKey.getEncoded()));
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

        byte[] bytes = cipher.doFinal(DES.getBytes());
        System.out.println("jdkDES encrypt:" + Hex.encodeHexString(bytes));
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] doFinal = cipher.doFinal(bytes);
        System.out.println("jdkDES decrypt:" + new String(doFinal));
    }


    public void bcDES() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 参数一：指定加密算法，参数二：自动生成器提供者(BC表示BouncyCastle)
        KeyGenerator generator = KeyGenerator.getInstance("DES", "BC");
        System.out.println("获取密钥生成器提供者为:" + generator.getProvider());
        // 设置密钥长度，DES必须为56位。new SecureRandom()为构造一个实现默认随机数算法的安全随机数生成器
        generator.init(new SecureRandom());
        SecretKey secretKey = generator.generateKey();
        System.out.println("secretKey的实现类为:" + secretKey.getClass());//class javax.crypto.spec.SecretKeySpec
        byte[] key = secretKey.getEncoded();

        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = factory.generateSecret(desKeySpec);
        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
        // SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] res = cipher.doFinal(DES.getBytes());
        System.out.println("bcDES encrypt:" + Hex.encodeHexString(res));
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        res = cipher.doFinal(res);
        System.out.println("bcDES decrypt:" + new String(res));
    }

}
