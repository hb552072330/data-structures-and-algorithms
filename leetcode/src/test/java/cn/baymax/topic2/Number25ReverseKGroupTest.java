package cn.baymax.topic2;

import cn.baymax.common.ListNode;
import cn.baymax.common.ListNodeUtil;
import junit.framework.TestCase;

/**
 * @author zhanghongbing
 * @data 2022/3/3
 */
public class Number25ReverseKGroupTest extends TestCase {

    public void testReverseKGroup() {
        ListNode listNode = ListNodeUtil.generateListnode(7);
        ListNodeUtil.loopNode(listNode);
        ListNodeUtil.loopNode(new Number25ReverseKGroup().reverseKGroup(listNode, 3));

    }
}