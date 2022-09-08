package class05;

/**
 * @author zhanghongbing
 * @data 2022/9/6
 * https://leetcode.cn/problems/divide-two-integers
 */

public class Code03BitAddMinusMultiDiv {

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {

            if ((i + 1) % 8 == 0) {
                System.out.print(" ");
            }
            //System.out.print(((num >> i) & 1) == 1 ? 1:0 );
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
        System.out.print(" > " + num);
        System.out.println();
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            //无进位相加
            sum = a ^ b;
            //printBinary(sum);
            //是否存在进位
            b = (a & b);
            //进位
            //printBinary(b);
            b = b << 1;
            //printBinary(b);
            a = sum;
            //printBinary(a);
        }
        return sum;
    }

    public static int negNum(int num) {
        return add(~num, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            //4*3 = (4 << 0) * ((3&)1 >>0)+ (4 << 1) * ((1&1) >>1)
            //printBinary(res);
            //printBinary(a << 1);
            //printBinary(b >>> 1);
            a <<= 1;//a*2
            b >>>= 1;//b/2
        }
        return res;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static int divide(int a, int b) {
        int x = isNegative(a) ? negNum(a) : a;
        int y = isNegative(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            //7/3  0000 0111 / 0000 0011
            //7右移一位 3  >= 3
            //7 - 6 = 1
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }

        return isNegative(a) ^ isNegative(b) ? negNum(res) : res;
    }

    public static int div(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MAX_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = divide(add(a, 1), b);
                //c = -max / b
                //c + (a-c*b)/b
                //minus(a, multi(c, b))
                return add(c, divide(minus(a, multi(c, b)), b));
            }
        } else {
            return divide(a, b);
        }
    }

    public static void main(String[] args) {
        printBinary(1);
        printBinary(2);
        printBinary(~2);
        printBinary(-1);
        //byte -1 原码 1000 0001
        //byte -1 反码 1111 1110
        //byte -1 补码 1111 1111
        printBinary(-2);
        printBinary(1 << -1);
        printBinary(Integer.MAX_VALUE);
        printBinary(Integer.MIN_VALUE);
        printBinary(-Integer.MAX_VALUE);
        System.out.println("============");
        System.out.println(add(7, 4));
        System.out.println(multi(4, 3));
        System.out.println(multi(4, -3));
        System.out.println(div(4, 3));
        System.out.println(div(6, 3));
        System.out.println(div(16, 3));
    }

}
