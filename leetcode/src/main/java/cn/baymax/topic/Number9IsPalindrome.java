package cn.baymax.topic;

/**
 * @author zhanghongbing
 * @data 2022/3/3
 */
public class Number9IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int pre = x;
        int temp = 0;
        while (pre != 0) {
            temp = pre % 10;
            y = y * 10 + temp;
            pre = pre / 10;
        }
        return y == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNubmer = 0;
        while (revertedNubmer < x) {
            revertedNubmer = revertedNubmer * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNubmer || revertedNubmer / 10 == x;
    }
}
