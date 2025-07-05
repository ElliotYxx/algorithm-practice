package com.algorithm.practice.day6;


//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

import com.algorithm.ListNode;

/// /
/// /
/// /
/// / 示例 1：
/// /
/// /
/// /输入：head = [1,2,3,4,5], n = 2
/// /输出：[1,2,3,5]
/// /
/// /
/// / 示例 2：
/// /
/// /
/// /输入：head = [1], n = 1
/// /输出：[]
/// /
/// /
/// / 示例 3：
/// /
/// /
/// /输入：head = [1,2], n = 1
/// /输出：[1]
public class RemoveNthFromEnd {


    public static void main(String[] args) {


        // case1 head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
        ListNode result1 = removeNthFromEnd(ListNode.createListNode(1, 2, 3, 4, 5), 2);
        ListNode.printList(result1);

        // case2 输入：head = [1], n = 1 输出：[]
        ListNode result2 = removeNthFromEnd(ListNode.createListNode(1), 1);
        ListNode.printList(result2);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;

        for (int i = 0; i < n; i++) {
            if (first == null){
                return head;
            }
            first = first.next;
        }

        ListNode curr = dummy;
        while(first != null){
            first = first.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return dummy.next;

    }
}
