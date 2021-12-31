package cn.baymax.base64;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;

/**
 * @author zhanghongbing
 * @data 2021/12/30
 */
public class OtherMDDemo {

    private static String OTHER = "OTHER";

    public void bcTiger(){
        Digest digest = new TigerDigest();
        digest.update(OTHER.getBytes(), 0, OTHER.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcTiger：" + Hex.encodeHexString(bytes));
    }

    public void bcGOST3411(){
        Digest digest = new GOST3411Digest();
        digest.update(OTHER.getBytes(), 0, OTHER.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcGOST3411：" + Hex.encodeHexString(bytes));
    }
    public void bcWhirlpoolDigest(){
        Digest digest = new WhirlpoolDigest();
        digest.update(OTHER.getBytes(), 0, OTHER.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        System.out.println("bcWhirlpoolDigest：" + Hex.encodeHexString(bytes));
    }

}
