package cn.baymax.base64;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.jcajce.provider.digest.RIPEMD128;

/**
 * @author zhanghongbing
 * @data 2021/12/30
 */
public class RipeMDDemo {

    private static String RIPEMD = "RIPEMD";

    public void bcRipeMD128() {
        Digest digest = new RIPEMD128Digest();
        digest.update(RIPEMD.getBytes(), 0, RIPEMD.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcRipeMD128：" + Hex.encodeHexString(bytes));
    }

    public void bcRipeMD160() {
        Digest digest = new RIPEMD160Digest();
        digest.update(RIPEMD.getBytes(), 0, RIPEMD.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcRipeMD160：" + Hex.encodeHexString(bytes));
    }

    public void bcRipeMD256() {
        Digest digest = new RIPEMD256Digest();
        digest.update(RIPEMD.getBytes(), 0, RIPEMD.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcRipeMD256：" + Hex.encodeHexString(bytes));
    }
}
