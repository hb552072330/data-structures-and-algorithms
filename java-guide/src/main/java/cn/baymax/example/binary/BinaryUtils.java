package cn.baymax.example.binary;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author zhanghongbing
 * @data 2021/10/21
 */
public class BinaryUtils {
    public static String int2BitStr(int value) {
        String ibstr = Integer.toBinaryString(value);//显示全部二进制字符
        DecimalFormat decimalFormat = new DecimalFormat("00000000000000000000000000000000");
        BigDecimal bigDecimal = new BigDecimal(ibstr);
        ibstr = decimalFormat.format(bigDecimal);
        String ibstr1_sub = ibstr.substring(0, 8) + " " + ibstr.substring(8, 16) + " " + ibstr.substring(16, 24) + " " + ibstr.substring(24, 32);
        return ibstr1_sub;
    }
}