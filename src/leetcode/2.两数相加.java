/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (40.75%)
 * Likes:    6657
 * Dislikes: 0
 * Total Accepted:    964.2K
 * Total Submissions: 2.4M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * @author bingxl<bingxl@outlook.com>
 * @date 2021/08/29 解决思路： 从两链表第一个节点开始将对应位相加，得到的和取个位作为结果对应位的节点值，超过9的向后进位。
 *       完全就是小学时学的加法思想。
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位值
        int carryOver = 0;
        ListNode firstNode = new ListNode();
        ListNode curNode = firstNode;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        // l1和l2只要有一个还有节点就继续
        while (l1Curr != null || l2Curr != null) {
            // l1 l2对应位相加,带上前一位的进位，没有值的节点用0代替
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
