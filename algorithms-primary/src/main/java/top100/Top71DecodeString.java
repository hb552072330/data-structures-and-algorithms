package top100;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

public class Top71DecodeString {

    public static String decodeString(String s) {
        return f(0, s.toCharArray()).ans;
    }

    public static Info f(int start, char[] chars) {
        StringBuilder cur = new StringBuilder();
        int times = 0;
        while (start < chars.length && chars[start] != ']') {
            if (Character.isDigit(chars[start])) {
                times = 10 * times + chars[start++] - '0';
            } else if (Character.isLowerCase(chars[start])) {
                cur.append(chars[start++]);
            } else {
                Info next = f(start + 1, chars);
                while (times > 0) {
                    cur.append(next.ans);
                    times--;
                }
                start = next.end + 1;
            }

        }
        return new Info(cur.toString(), start);
    }

    public static class Info {
        String ans;
        int end;

        public Info(String ans, int end) {
            this.ans = ans;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
    }

}
