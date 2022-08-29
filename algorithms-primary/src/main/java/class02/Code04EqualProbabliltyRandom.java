package class02;

/**
 * @author zhanghongbing
 * @data 2022/8/26
 */
public class Code04EqualProbabliltyRandom {
    public static int f() {
        return Math.random() < 0.9 ? 0 : 1;
    }

    public static int g() {
        int ans;
        do {
            ans = f();
        } while (ans == f());
        return ans;
    }

    public static void main(String[] args) {
        int[] countArr = new int[2];
        int[] countArr2 = new int[2];
        int testTimes = 100000;
        //140420
        //100000
        for (int i = 0; i < testTimes; i++) {
            int f = f();
            countArr[f]++;
            int g = g();
            countArr2[g]++;
        }
        System.out.println(countArr[0] + " , " + countArr[1]);
        System.out.println((double) countArr[0] / (double) testTimes);
        System.out.println((double) countArr2[0] / (double) testTimes);

    }

}
