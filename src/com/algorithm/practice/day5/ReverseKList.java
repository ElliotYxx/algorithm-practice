package com.algorithm.practice.day5;

import com.algorithm.ListNode;

import static com.algorithm.ListNode.printList;

/**
 * @Author: Elliot
 * @Date: 2025-07-01 17:47
 * @Description: todo
 *
 *  *      * 给你链表的头节点head，每k个节点一组进行翻转，请你返回修改后的链表。
 *  *      * k是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *  *      * 不允许修改节点的值，而是需要œ实际进行节点交换。
 *  *      *
 *  *      * 输入：head = [1,2,3,4,5], k = 2
 *  *      * 输出：[2,1,4,3,5]
 *  *      *
 *  *      * 输入：head = [1,2,3,4,5], k = 3
 *  *      * 输出：[3,2,1,4,5]
 **/

public class ReverseKList {


    public static void main(String[] args) {

        // case1
        ListNode head = ListNode.createListNode(1,2,3,4,5);
        printList(head);
        ListNode newHead = reverseKGroup(head, 2);
        printList(newHead);

        // case 2
        ListNode head2 = ListNode.createListNode(1,2,3,4,5);
        printList(head2);
        ListNode newHead2 = reverseKGroup(head2, 3);
        printList(newHead2);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // 计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 分组反转
        for (int i = 0; i < length / k; i++) {
            // 反转k个节点
            ListNode cur = pre.next;
            for (int j = 1; j < k; j++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }

            // 移动pre到下一组的前一个节点
            for (int j = 0; j < k; j++) {
                pre = pre.next;
            }
        }

        return dummy.next;
    }

}

