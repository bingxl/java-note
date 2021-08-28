/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
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
// @lc code=end
