package cn.baymax.example.binary;

/**
 * @author zhanghongbing
 * @data 2021/10/21
 */
public class BitOperation {
    public static void main(String[] args) {
        int i = -6;
        String ibstr = BinaryUtils.int2BitStr(i);
        System.out.println(Integer.toBinaryString(1));
        System.out.println("将要转换的数展示:   " + ibstr);
        int i1 = i >>> 2;
        int i2 = i >> 2;
        System.out.println("无符号右移结果为:   " + BinaryUtils.int2BitStr(i1));
        System.out.println("其十进制形式展示:   " + i1);
        System.out.println("有符号右移结果为:   " + BinaryUtils.int2BitStr(i2));
        System.out.println("其十进制形式展示:   " + i2);

        System.out.println("-----------------------------------------------------");
        System.out.println(BinaryUtils.int2BitStr(3));
        System.out.println("源码：10000000 00000000 00000000 00000011");
        System.out.println("反码：11111111 11111111 11111111 11111100");
        System.out.println("补码：" + BinaryUtils.int2BitStr(-3));
        //与运算符 &
        //与运算符用符号“&”表示，其使用规律如下：
        //两个操作数中位都为1，结果才为1，否则结果为0
        System.out.println("-----------------------------------------------------");
        int a = 129;
        int b = 128;
        System.out.println(BinaryUtils.int2BitStr(a));
        System.out.println(BinaryUtils.int2BitStr(b));
        System.out.println("a & b = " + (a & b));
        System.out.println(BinaryUtils.int2BitStr(a & b));
        //或运算符用符号“|”表示，其运算规律如下：
        //两个位只要有一个为1，那么结果就是1，否则就为0
        System.out.println("a | b = " + (a | b));
        System.out.println(BinaryUtils.int2BitStr(a | b));
        System.out.println("-----------------------------------------------------");
        //非运算符 ~
        //非运算符用符号“~”表示，其运算规律如下：
        //如果位为0，结果是1，如果位为1，结果是0
        System.out.println(" 3：" + BinaryUtils.int2BitStr(3));
        System.out.println("~3：" + ~3);
        System.out.println("~3：" + BinaryUtils.int2BitStr(~3));
        //补码：11111111 11111111 11111111 11111100
        //反码：11111111 11111111 11111111 11111011
        //源码：10000000 00000000 00000000 00000100  -4
        System.out.println(" -3：" + BinaryUtils.int2BitStr(-3));
        System.out.println("~-3：" + ~-3);
        System.out.println("~-3：" + BinaryUtils.int2BitStr(~-3));
        System.out.println("-----------------------------------------------------");
        //异或运算符 ^
        //异或运算符是用符号“^”表示的，其运算规律是：
        //两个操作数的位中，相同则结果为0，不同则结果为1
        System.out.println("    2 ：" + BinaryUtils.int2BitStr(2));
        System.out.println("    15：" + BinaryUtils.int2BitStr(15));
        System.out.println("2 ^ 15：" + (2 ^ 15));
        System.out.println("2 ^ 15：" + BinaryUtils.int2BitStr(2 ^ 15));
        System.out.println("-----------------------------------------------------");
        System.out.println("Integer MAX:" + BinaryUtils.int2BitStr(Integer.MAX_VALUE));
        System.out.println("Integer >>> 16:" + BinaryUtils.int2BitStr(Integer.MAX_VALUE >>> 16));
        System.out.println("Integer >>> 16:" + (Integer.MAX_VALUE >>> 16));
        System.out.println("MAX ^ (max >>> 16)" + (Integer.MAX_VALUE ^ (Integer.MAX_VALUE >>> 16)));
        System.out.println("MAX ^ (max >>> 16)" + BinaryUtils.int2BitStr(Integer.MAX_VALUE ^ (Integer.MAX_VALUE >>> 16)));

        //
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(BinaryUtils.int2BitStr(-536870912));
        System.out.println(BinaryUtils.int2BitStr(536870911));
        System.out.println(BinaryUtils.int2BitStr((1 << Integer.SIZE - 3) - 1));

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("INTEGER      SIZE:" + BinaryUtils.int2BitStr(Integer.SIZE));
        System.out.println("INTEGER  -3 +SIZE:" + BinaryUtils.int2BitStr(Integer.SIZE - 3));
        System.out.println("INTEGER -1<< SIZE:" + BinaryUtils.int2BitStr(-1 << (Integer.SIZE - 3)));
        System.out.println("INTEGER  0<< SIZE:" + BinaryUtils.int2BitStr(0 << (Integer.SIZE - 3)));
        System.out.println("INTEGER  1<< SIZE:" + BinaryUtils.int2BitStr(1 << (Integer.SIZE - 3)));
        System.out.println("INTEGER  2<< SIZE:" + BinaryUtils.int2BitStr(2 << (Integer.SIZE - 3)));
        System.out.println("INTEGER  3<< SIZE:" + BinaryUtils.int2BitStr(3 << (Integer.SIZE - 3)));
        System.out.println(BinaryUtils.int2BitStr(((1 << Integer.SIZE - 3) - 1)));
        System.out.println(BinaryUtils.int2BitStr(~((1 << Integer.SIZE - 3) - 1)));

    }
}
