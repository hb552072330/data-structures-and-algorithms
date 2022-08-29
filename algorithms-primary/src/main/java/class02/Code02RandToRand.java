package class02;

/**
 * @author zhanghongbing
 * @data 2022/8/24
 */
public class Code02RandToRand {

    public static void main(String[] args) {
        System.out.println("测试开始");
        int testTimes = 10_000_000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.98) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println(5f / 8f);
        System.out.println((double) count / (double) testTimes);

        int k = 9;
        int[] counts = new int[k];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "这个数出现了 " + counts[i] + " 次");
        }

        System.out.println("===================");

        count = 0;
        double x = 0.18f;
        for (int i = 0; i < testTimes; i++) {
            if (xToPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
        System.out.println("===================");
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println("===================");

        int[] counts2 = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int ans = f4();
            if (ans == 8) {
                System.out.println(ans);
            }
            counts2[ans]++;
        }
        for (int i = 0; i < counts2.length; i++) {
            System.out.println(i + "这个数出现了 " + counts2[i] + " 次");
        }

        System.out.println("===================");
    }

    private static double xToPower2() {
        return Math.max(Math.random(), Math.random());
    }

    private static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    private static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans == 3);
        return ans > 3 ? 0 : 1;
    }

    private static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    public static int f4() {
        int ans;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }

}
