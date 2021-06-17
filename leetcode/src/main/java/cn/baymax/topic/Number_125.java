package cn.baymax.topic;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class Number_125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        s = sb.toString();
        return s.equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int rightindex = chars.length - 1;
        int leftIndex = 0;
        for (; leftIndex < rightindex; ) {
            while (leftIndex < rightindex && !Character.isLetterOrDigit(chars[leftIndex])) {
                leftIndex++;
            }
            while (leftIndex < rightindex && !Character.isLetterOrDigit(chars[rightindex])) {
                rightindex--;
            }
            if (Character.toLowerCase(chars[leftIndex]) == Character.toLowerCase(chars[rightindex])) {
                leftIndex++;
                rightindex--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(array[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(array[end])) {
                end--;
                continue;
            }
            if (Character.toLowerCase(array[start]) != Character.toLowerCase(array[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
