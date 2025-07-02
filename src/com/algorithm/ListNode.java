package com.algorithm;

/**
 * @Author: Elliot
 * @Date: 2025-07-01 17:47
 * @Description: todo
 **/
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(Integer... nums){
        if (nums == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (Integer num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
