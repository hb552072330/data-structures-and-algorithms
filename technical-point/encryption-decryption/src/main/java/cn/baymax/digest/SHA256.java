package cn.baymax.digest;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author zhanghongbing
 * @data 2022/3/8
 */
public class SHA256 {
    //access_token=3024edf9-ea2c-45f0-9d17-4922d1dc9cdc&app_key=6851519797009122830&method=logistics.getShopKey&param_json={}&timestamp=2022-03-08 13:53:13&v=2&sign=ab3387e5&sign_method=hmac-sha256",


    //static String access_token = "3024edf9-ea2c-45f0-9d17-4922d1dc9cdc";
    static String access_token = "1ac6d926-d48c-43db-9a27-6020c3cf9435";
    static String method = "logistics.getShopKey";
    static String param_json = "{}";
    static String timestamp = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN);
    static String v = "2";
    static String app_key = "6851519797009122830";
    static String app_secret = "bc19710e-0926-4f29-8e35-e88b6bc83841";

    public static void main(String[] args) throws Exception {
    /*    //$paramPattern = 'app_key'.$appKey.'method'.$method.'param_json'.$paramJson.'timestamp'.$timestamp.'v'.$v;
        // 拼接后的格式差不多是这样：
        // app_key***method***param_json***timestamp***v*
        String paramPattern  = String.format("app_key%smethod%sparam_json%stimestamp%sv%s", app_key, method, param_json, timestamp, v);
        System.out.println(paramPattern );
        //$signPattern = $appSecret.$paramPattern.$appSecret;
        paramPattern  = String.format("%s%s%s", app_secret, paramPattern, app_secret);
        System.out.println(paramPattern );
        //$sign = hash_hmac("sha256", $signPattern, $appSecret);
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] digest = messageDigest.digest(paramPattern.getBytes());
        System.out.println("jdkSHA256:" + Hex.encodeHexString(digest));*/
        long time = System.currentTimeMillis();
        String sign = sign(app_key, app_secret, method, time, param_json);
        System.out.println(sign);
        String params = String.format("access_token=%s&app_key=%s&method=logistics.getShopKey&param_json={}&timestamp=%s&v=2&sign=%s&sign_method=hmac-sha256",
                access_token, app_key, time,sign);
        System.out.println("0000");
        System.out.println(params);
        System.out.println("0000");
    }

    // 计算签名
    public static String sign(String appKey, String appSecret, String method, long timestamp, String paramJson) {
        // 按给定规则拼接参数
        String paramPattern = "app_key" + appKey + "method" + method + "param_json" + paramJson + "timestamp" + timestamp + "v2";
        String signPattern = appSecret + paramPattern + appSecret;
        System.out.println("sign_pattern:" + signPattern);

        return hmac(signPattern, appSecret);
    }

    //
    // 计算hmac
    public static String hmac(String plainText, String appSecret) {
        Mac mac;
        try {
            byte[] secret = appSecret.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(secret, "HmacSHA256");

            mac = Mac.getInstance("HmacSHA256");
            mac.init(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return "";
        }

        byte[] plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] digest = mac.doFinal(plainBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
