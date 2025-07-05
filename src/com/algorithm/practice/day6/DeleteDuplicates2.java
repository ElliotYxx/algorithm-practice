package com.algorithm.practice.day6;

import com.algorithm.ListNode;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
public class DeleteDuplicates2 {

    public static void main(String[] args) {

        // case1 head = [1,2,3,3,4,4,5]  输出：[1,2,5]
        ListNode result1 = deleteDuplicates(ListNode.createListNode(1,2,3,3,4,4,5));
        ListNode.printList(result1);

        // case2 head = [1,1,1,2,3]  输出：[2,3]
        ListNode result2 = deleteDuplicates(ListNode.createListNode(1,1,1,2,3));
        ListNode.printList(result2);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null){
            int nextVal = curr.next.val;
            if (nextVal == curr.next.next.val){
                while(curr.next != null && curr.next.val == nextVal){
                    // delete
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
