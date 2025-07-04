package com.algorithm.practice.day5;


import com.algorithm.ListNode;

import static com.algorithm.ListNode.printList;

//给你单链表的头结点 head ，请你找出并返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
public class MiddleNode {

    public static void main(String[] args) {

        ListNode result1 = middleNode(ListNode.createListNode(1, 2, 3, 4, 5));
        printList(result1);


        ListNode result2 = middleNode(ListNode.createListNode(1,2,3,4,5,6));
        printList(result2);

    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


}
