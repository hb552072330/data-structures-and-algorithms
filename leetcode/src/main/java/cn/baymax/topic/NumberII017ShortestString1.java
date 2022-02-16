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
public class NumberII017ShortestString1 {
    public String minWindow(String s, String t) {

        int sourceLenth = s.length();
        int targetLenth = t.length();
        if (sourceLenth < targetLenth) {
            return new String();
        }
        //定义Map用来统计t中字符出现的次数
        Map<Character, Integer> targetMap = new HashMap<>();
        //统计出t所有字符出现的次数
        for (int i = 0; i < targetLenth; i++) {
            char currentChar = t.charAt(i);
            targetMap.put(currentChar, targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        //定义窗口的开始和长度
        int start = -1;
        int len = Integer.MAX_VALUE;
        int tempIndex = 0;
        //循环s的字符集
        for (int currentIndex = 0; currentIndex < sourceLenth; currentIndex++) {
            //判断当前当前已循环的字符集是否包含所有t的字符
            if (targetMap.containsKey(s.charAt(currentIndex))) {
                if (targetMap.get(s.charAt(currentIndex)) > 0) {
                    targetLenth--;
                }
                targetMap.put(s.charAt(currentIndex), targetMap.get(s.charAt(currentIndex)) - 1);
            }
            if (targetLenth == 0) {
                while (true) {
                    //包含且<0 向前推进start的下标
                    if (targetMap.containsKey(s.charAt(tempIndex))) {
                        if (targetMap.get(s.charAt(tempIndex)) < 0) {
                            targetMap.put(s.charAt(tempIndex), targetMap.get(s.charAt(tempIndex)) + 1);
                            tempIndex++;
                        } else {
                            break;
                        }
                    } else {
                        tempIndex++;
                    }

                }
                if (currentIndex - tempIndex + 1 < len) {
                    len = currentIndex - tempIndex + 1;
                    start = tempIndex;
                }
            }

        }
        if (start == -1) {
            return new String();
        }
        return s.substring(start, start + len);
    }
}
