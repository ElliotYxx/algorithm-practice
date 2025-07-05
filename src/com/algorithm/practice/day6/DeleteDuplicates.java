package com.algorithm.practice.day6;


import com.algorithm.ListNode;

//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
public class DeleteDuplicates {

    public static void main(String[] args) {


        // case1 head = [1,1,2]  输出：[1,2]
        ListNode result1 = deleteDuplicates(ListNode.createListNode(1,1,2));
        ListNode.printList(result1);

        // case2 head = [1,1,2,3,3]  输出：[1,2,3]
        ListNode result2 = deleteDuplicates(ListNode.createListNode(1,1,2,3,3));
        ListNode.printList(result2);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while(curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            curr = curr.next;

        }

        return dummy.next;
    }
}
