package top100;

public class Top85NumSquares {
    public int numSquares(int n) {
        int res = n, num = 2;
        while (num * num <= n) {
            int a = n / (num * num), b = n % (num * num);
            res = Math.min(res, a + numSquares(b));
            num++;
        }
        return res;
    }

    public int numSquares2(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        int f = (int) Math.sqrt(n);
        if (f * f == n) {
            return 1;
        }
        for (int a = 0; a * a < n; a++) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                return (a > 0 && b > 0) ? 2 : 1;
            }
        }
        return 3;
    }
}
