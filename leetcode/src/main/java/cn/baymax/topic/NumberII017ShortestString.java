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
public class NumberII017ShortestString {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();

        //s.length < t.length 返回空串
        if (sn < tn) {
            return new String();
        }

        int need_cnt = tn;
        Map<Character, Integer> need_char_cnt = new HashMap<>();
        for (int i = 0; i < tn; i++) {
            char c = t.charAt(i);
            //put key = c  value = c出现的次数 累加
            need_char_cnt.put(c, need_char_cnt.getOrDefault(c, 0) + 1);
        }

        int res_start = -1;//窗口开始下标
        int res_len = Integer.MAX_VALUE;//窗口长度

        int l = 0;//窗口临时开始下标
        for (int r = 0; r < sn; r++) {
            if (need_char_cnt.containsKey(s.charAt(r)) == true) {
                if (need_char_cnt.get(s.charAt(r)) > 0){//说明s未包含所有t的字符
                    need_cnt--;
                }

                need_char_cnt.put(s.charAt(r), need_char_cnt.get(s.charAt(r)) - 1);
            }

            if (need_cnt == 0) {//s中的字符全部包含t的字符集
                while (true) {
                    if (need_char_cnt.containsKey(s.charAt(l)) == false)
                        l++;
                    else {

                        if (need_char_cnt.get(s.charAt(l)) < 0) {//字符多次出现缩小床大小
                            need_char_cnt.put(s.charAt(l), need_char_cnt.get(s.charAt(l)) + 1);
                            l++;
                        } else {
                            break;
                        }
                    }
                }
                //r当前循环
                //l窗口开始下标
                //res_len 窗口长度
                if (r - l + 1 < res_len) {
                    res_len = r - l + 1;
                    res_start = l;
                }
            }
        }

        if (res_start == -1) {
            return new String();
        }
        return s.substring(res_start, res_start + res_len);
    }

}
