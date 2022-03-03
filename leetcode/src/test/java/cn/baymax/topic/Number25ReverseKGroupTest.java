package cn.baymax.topic;

import cn.baymax.common.ListNode;
import cn.baymax.common.ListNodeUtil;
import cn.baymax.topic2.Number25ReverseKGroup;
import org.junit.Test;

/**
 * @author zhanghongbing
 * @data 2021/7/2
 */
public class Number25ReverseKGroupTest {

    @Test
    public void reverseKGroup() {
        ListNode listNode = ListNodeUtil.generateListnode(4);
        ListNodeUtil.loopNode(listNode);
        ListNodeUtil.loopNode(new cn.baymax.topic.Number25ReverseKGroup().reverseKGroup(listNode, 3));
    }
    @Test
    public void reverseKGroup2() {
        ListNode listNode = ListNodeUtil.generateListnode(7);
        ListNodeUtil.loopNode(listNode);
        ListNodeUtil.loopNode(new Number25ReverseKGroup2().reverseKGroup(listNode, 3));
    }


}