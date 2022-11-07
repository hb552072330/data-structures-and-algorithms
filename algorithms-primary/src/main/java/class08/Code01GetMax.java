package class08;

public class Code01GetMax {
    public static int flip(int n) {
        return n ^ 1;//无符号相加 正数 偶数
    }

    public static int sign(int n) {
        //(n >> 31) & 1  正数 = 0 负数为1
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b; // a - b > 0  ++
        int scA = sign(c);//1
        int scB = flip(scA);//0
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int scA = sign(a);
        int scB = sign(b);
        int scC = sign(c);
        int difSab = scA ^ scB;
        int samSab = flip(difSab);
        int returnA = scA * difSab + samSab * scC;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void printBinary(int n) {
        for (int i = 31; i >= 0; i--) {
            if ((i + 1) % 8 == 0) {
                System.out.print(" ");
            }
            System.out.print(((1 << i) & n) == 0 ? 0 : 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(1);
        printBinary(-1);
        System.out.println((Integer.MAX_VALUE >> 31) & 1);
        System.out.println((Integer.MAX_VALUE >> 30) & 1);
        System.out.println((Integer.MIN_VALUE >> 31) & 1);
        System.out.println((-1 >> 31) & 1);
        System.out.println((Integer.MIN_VALUE >> 30) & 1);
        System.out.println("-----------");
        System.out.println(getMax1(2, 3));
        System.out.println(getMax2(2, 3));
        int a = Integer.MAX_VALUE;
        int b = -123232323;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
    }
}
