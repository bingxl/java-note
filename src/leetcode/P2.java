package leetcode;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 两数相加
 * 
 * @link {https://leetcode-cn.com/problems/add-two-numbers/}
 * @author bingxl <bingxl@outlook.com>
 */
public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode firstNode = new ListNode();
        ListNode curNode = firstNode;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        while (l1Curr != null || l2Curr != null) {
            // l1 l2对应位相加,带上前一位的进位.
            int addValue = (l1Curr == null ? 0 : l1Curr.val) + (l2Curr == null ? 0 : l2Curr.val) + carryOver;

            curNode.next = new ListNode(addValue % 10);
            curNode = curNode.next;
            carryOver = addValue >= 10 ? 1 : 0;

            l1Curr = l1Curr == null ? null : l1Curr.next;
            l2Curr = l2Curr == null ? null : l2Curr.next;
        }

        // 最后部分还有进位时
        curNode.next = carryOver != 0 ? new ListNode(carryOver) : null;

        // firstNode的val为空, 所以从next开始
        return firstNode.next;
    }
}

/**
 * 两数相加 思路 循环两个链表,将对应位相加再加前一位的进位得到该位的和, 取位的个位插入结果链表中
 */