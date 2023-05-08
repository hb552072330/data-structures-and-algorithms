package cn.baymax.mac01;

public class Code01_Swap {

    public static void printBinary(int i) {
        for (int i1 = 31; i1 >= 0; i1--) {
            System.out.print(((1 << i1) & i) == 0 ? 0 : 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(1);
        printBinary(-1);
        int a = 3, b = 5;
        System.out.println(a ^ b);

        System.out.println(a);
        System.out.println(b);
        a = a ^ b;
        printBinary(a ^ b);
        b = a ^ b;
        printBinary(a ^ b);
        a = a ^ b;
        printBinary(a ^ b);
        System.out.println(a);
        System.out.println(b);
        System.out.println("========");
        printBinary(8);
        printBinary(-8);
        printBinary(64);
        printBinary(-64);
        printBinary(8 & -8);
        System.out.println(8 & -8);
        System.out.println(64 & -64);

    }
}
