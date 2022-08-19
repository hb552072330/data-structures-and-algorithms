package class01;

/**
 * @author zhanghongbing
 * @data 2022/8/19
 */
public class Code02SumOfFactorial {

    public static int f1(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    public static int factorial(int num) {
        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans *= i;
        }
        return ans;
    }

    public static int f2(int num) {
        int ans = 0;
        int current = 1;
        for (int i = 1; i <= num; i++) {
            current *= i;
            ans += current;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(f1(num));
        System.out.println(f2(num));
    }

}
