package com.shilong.interview.gaode0920;

import java.util.HashSet;

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {

	// 删除链表中出现的所有重复节点
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		// Set 用来存储已经遇到的节点值
		HashSet<Integer> seen = new HashSet<>();
		// 哑节点（dummy node），避免处理头节点删除的特殊情况
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;

		while (current != null) {
			// 如果当前节点的值已经在 HashSet 中存在，则彻底删除该节点
			if (seen.contains(current.value)) {
				prev.next = current.next;  // 跳过当前节点
			} else {
				// 如果是第一次出现的值，则记录到 HashSet 中
				seen.add(current.value);
				prev = current;  // 保持 prev 指针指向当前节点
			}
			current = current.next;  // 继续遍历
		}
		return dummy.next;
	}

	// 打印链表
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 构造链表 1 -> 2 -> 3 -> 2 -> 4 -> 3
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(3);

		System.out.println("原链表：");
		printList(head);

		head = deleteDuplicates(head);

		System.out.println("删除重复节点后的链表：");
		printList(head);
	}
}
