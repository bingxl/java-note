package cn.bingxl.leetcode;

/**
 * 整型链表
 * 
 * @author bingxl <bingxl@outlook.com>
 */
public class ListNode {

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