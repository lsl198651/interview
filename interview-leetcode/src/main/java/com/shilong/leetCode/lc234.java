package com.shilong.leetCode;

import java.util.ArrayList;
import java.util.List;

// 给你一个单链表的头节点 head ，请你判断该链表是否为		回文链表
// 。如果是，返回 true ；否则，返回 false 。
public class lc234 {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
	head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    System.out.println(isPalindrome(head));
  }

  public static boolean isPalindrome(ListNode head) {
      List<Integer> vals = new ArrayList<Integer>();

      // 将链表的值复制到数组中
      // ListNode currentNode = head;
      while (head != null) {
          vals.add(head.val);
          head = head.next;
      }

      // 使用双指针判断是否回文
      int front = 0;
      int back = vals.size() - 1;
      while (front < back) {
          if (!vals.get(front).equals(vals.get(back))) {
              return false;
          }
          front++;
          back--;
      }
      return true;

  }
}
