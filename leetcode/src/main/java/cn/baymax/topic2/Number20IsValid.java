package cn.baymax.topic2;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串 👍 3035 👎 0

import java.util.*;

/**
 * @author zhanghongbing
 * @data 2022/3/4
 */
public class Number20IsValid {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (pairs.keySet().contains(aChar)) {
                if (stack.isEmpty() || stack.peek().equals(pairs.get(aChar))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('[', ']');
            put('{', '}');
            put('(', ')');
        }};
        LinkedList<Character> list = new LinkedList<Character>() {{
            add('?');
        }};
        Set<Character> set = pairs.keySet();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                list.addLast(c);
            } else {
                Character get = list.removeLast();
                if (pairs.get(get) != null && pairs.get(get) != c) {
                    return false;
                }
            }
        }
        return list.size() == 1;
    }
}
