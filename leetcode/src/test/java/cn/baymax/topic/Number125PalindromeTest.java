package cn.baymax.topic;

import org.junit.Assert;
import org.junit.Test;

public class Number125PalindromeTest {
    public static final String STR_1 = "A man, a plan, a canal: Panama";
    public static final String STR_2 = "race a car";
    public static final String STR_3 = "0P";
    Number125Palindrome number_125 = new Number125Palindrome();

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(number_125.isPalindrome(STR_1));
        Assert.assertFalse(number_125.isPalindrome(STR_2));
        Assert.assertFalse(number_125.isPalindrome(STR_3));
    }

    @Test
    public void testIsPalindrome2() {
        Assert.assertTrue(number_125.isPalindrome2(STR_1));
        Assert.assertFalse(number_125.isPalindrome2(STR_2));
        Assert.assertFalse(number_125.isPalindrome2(STR_3));
    }

    @Test
    public void testIsPalindrome3() {
        Assert.assertTrue(number_125.isPalindrome3(STR_1));
        Assert.assertFalse(number_125.isPalindrome3(STR_2));
        Assert.assertFalse(number_125.isPalindrome3(STR_3));
    }

}