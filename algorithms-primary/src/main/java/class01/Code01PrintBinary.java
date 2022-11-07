package class01;

/**
 * @author zhanghongbing
 * @data 2022/8/18
 */
public class Code01PrintBinary {

    private final static int DIGIT = 31;

    public static void printBinary(int num) {
        for (int digit = DIGIT; digit >= 0; digit--) {
            if ((digit + 1) % 8 == 0 && digit < 31) {
                System.out.print("  ");
            }
            System.out.print((num & (1 << digit)) == 0 ? 0 : 1);
        }
        System.out.println("   -> " + num);
    }

    //-7原码 10000000  00000000  00000000  00000111
    //-7反码 11111111  11111111  11111111  11111000
    //-7补码 11111111  11111111  11111111  11111001  +1
    public static void main(String[] args) {
        printBinary(1);
        printBinary(~1);
        printBinary(3);
        printBinary(1 ^ 3);
        printBinary(1 ^ 3 ^ 3);
        printBinary(5);
        printBinary(7);
        printBinary(5 | 7);//有1为1
        printBinary(5 ^ 7);//相同为0
        printBinary(5 & 7);//同时为1
        printBinary(1);
        printBinary(-1);
        printBinary(7);
        printBinary(7 << 1);
        printBinary(7 >> 1);
        printBinary(7 >>> 1);
        System.out.println(Integer.toBinaryString(-7));
        printBinary(-7);
        printBinary(-7 << 1);
        printBinary(-7 >> 1);
        printBinary(-7 >>> 1);
        printBinary(Integer.MAX_VALUE);
        printBinary(-Integer.MAX_VALUE);
        printBinary(Integer.MIN_VALUE);
        printBinary(-Integer.MIN_VALUE);
        System.out.println("~~~~");
        printBinary(63);
        printBinary(64);
        printBinary(65 & 63);
        printBinary(1 << (65 & 63));

        printBinary(64 >> 6);

        //printBinary(164 & 63);
        //printBinary(164 % 64);
        System.out.println("~~~~~~~~~~~");
        System.out.println(3^4);
        System.out.println(4^4);
        System.out.println(4^5);


    }

}
