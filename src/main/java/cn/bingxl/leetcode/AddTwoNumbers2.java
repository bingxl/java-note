package cn.bingxl.leetcode;

/**
 * [2] 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * @author bingxl<bingxl@outlook.com>
 * 
 */

import java.util.ArrayList;

public class AddTwoNumbers2 {

    /**
     * Definition for singly-linked list.
     * 
     */
    public static class ListNode {
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
     * 
     * @param li
     * @return
     */
    public static int[] listToArray(ListNode li) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (li != null) {
            list.add(li.val);
            li = li.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static ListNode arrayToList(int[] nums) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int i : nums) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return node.next;
    }

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
