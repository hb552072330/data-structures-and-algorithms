package cn.baymax.mac05;

public class PrimeNumber {


    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + ",");
            }
        }
    }

    public static boolean isPrimeNumber(int num) {
        boolean ans = true;
        if (num > 1 && num <= 3) {

        } else if (num > 3) {
            //是否是偶数
            boolean isEven = (num & 1) == 0;
            if (isEven) {
                return false;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    ans = false;
                    break;
                }
            }
        } else {
            ans = false;
        }
        return ans;
    }
}
