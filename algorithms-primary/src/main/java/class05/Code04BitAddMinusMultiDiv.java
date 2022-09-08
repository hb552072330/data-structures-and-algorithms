package class05;

/**
 * @author zhanghongbing
 * @data 2022/9/6
 * https://leetcode.cn/problems/divide-two-integers
 */

public class Code04BitAddMinusMultiDiv {


    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = a & b;
            a = sum;
            b <<= 1;
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
            if ((1 & b) == 1) {
                res = add(res, a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return res;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static int divideUnBinary(int a, int b) {
        int x = isNegative(a) ? negNum(a) : a;
        int y = isNegative(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
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
        } else if(b == Integer.MIN_VALUE){
            return 0;
        }else if(a == Integer.MIN_VALUE){
            if(negNum(1) == b){
                return Integer.MAX_VALUE;
            }
            int c = divideUnBinary(add(a,1),b);
            return add(c, divideUnBinary(minus(a, multi(c,b)),b));
        } else {
            return divideUnBinary(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println("============");
        System.out.println(add(7, 4));
        System.out.println(minus(7, 4));
        System.out.println(multi(4, 3));
        System.out.println(multi(4, -3));
        System.out.println(divideUnBinary(4, -3));
        System.out.println(divideUnBinary(4, 3));
        System.out.println(divideUnBinary(4, -5));
        System.out.println(div(4, -5));
        System.out.println(div(12, -5));
        System.out.println(div(22, -5));
        System.out.println(div(3, 1));
        System.out.println(div(10, 3));
        System.out.println(div(Integer.MIN_VALUE, -1));
    }

}
