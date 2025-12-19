package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 21:49
 **/
public class Top125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        String lowerCase = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (Character.isLetterOrDigit(lowerCase.charAt(l)) && Character.isLetterOrDigit(lowerCase.charAt(r))) {
                if (lowerCase.charAt(l++) != lowerCase.charAt(r--)) {
                    return false;
                }
            } else if (!Character.isLetterOrDigit(lowerCase.charAt(l))) {
                l++;
            } else {
                r--;
            }
        }
        return true;
    }
}
