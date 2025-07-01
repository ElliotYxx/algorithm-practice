package interview;

import java.util.List;

/**
 * @Author: Elliot
 * @Date: 2025-06-26 19:33
 * @Description: todo
 *
 * a	给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 	b	示例 1：
 * 	i	输入：head = [1,2,3,4,5], left = 2, right = 4
 * 	ii	输出：[1,4,3,2,5]
 * 	c	示例 2：
 * 	i	输入：head = [5], left = 1, right = 1
 * 	ii	输出：[5]
 * 	d	提示：
 * 	i	链表中节点数目为 n
 * 	ii	1 <= n <= 500
 * 	iii	-500 <= Node.val <= 500
 * 	iv	1 <= left <= right <= n
 **/
public class HaluoTest2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode curr = l1;

        System.out.println("before reverseList:");
        while (curr != null){
            System.out.print(curr.val + "");
            curr = curr.next;
        }

        ListNode result = reverseList(l1, 2, 4);
        curr = result;
        System.out.println("\nafter reverseList:");
        while (curr != null){
            System.out.print(curr.val + "");
            curr = curr.next;
        }
        System.out.println("");


        // case 2
        ListNode a = new ListNode(5);
        ListNode result2 = reverseList(a, 1, 1);

        curr = result2;
        while (curr != null){
            System.out.print(curr.val + "");
            curr = curr.next;
        }


    }


    private static ListNode reverseList(ListNode head, Integer start, Integer end) {

        if (head == null || head.next == null) {
            return head;
        }

        if (start > end){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < start; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode prev = null;

        for (int i = start; i <= end; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        pre.next.next = curr;
        pre.next = prev;
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}