package cn.baymax.topic;

//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。
//
//
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
// 示例 3：
//
//
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 10⁵
// s 和 t 由英文字母组成
//
//
//
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
//
//
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/
// Related Topics 哈希表 字符串 滑动窗口 👍 20 👎 0


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghongbing
 * @data 2022/2/15
 */
public class NumberII017ShortestString2 {
    public String minWindow(String s, String t) {

        int sl = s.length();
        int tl = t.length();

        if (sl < tl) {
            return new String();
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int startLen = -1;
        int addLen = Integer.MAX_VALUE;

        int currentWinStar = 0;
        for (int current = 0; current < sl; current++) {
            char c = s.charAt(current);
            if (targetMap.containsKey(c)) {
                if (targetMap.get(c) > 0) {
                    tl--;
                }
                targetMap.put(c, targetMap.get(c) - 1);
            }
            if (tl == 0) {
                while (true){
                    if (targetMap.containsKey(s.charAt(currentWinStar))) {
                        if (targetMap.get(s.charAt(currentWinStar)) < 0) {
                            targetMap.put(s.charAt(currentWinStar), targetMap.get(s.charAt(currentWinStar)) + 1);
                            currentWinStar++;
                        } else {
                            break;
                        }

                    } else {
                        currentWinStar++;
                    }
                }
                if (current - currentWinStar + 1 < addLen) {
                    startLen = currentWinStar;
                    addLen = current - currentWinStar + 1;
                }
            }
        }
        if (startLen == -1) {
            return new String();
        }
        return s.substring(startLen, startLen + addLen);
    }
}
