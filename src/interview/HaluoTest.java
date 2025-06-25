package interview;

/**
 * @Author: Elliot
 * @Date: 2025-06-18 19:03
 * @Description: 哈啰一面
 *
 *      * 给你链表的头节点head，每k个节点一组进行翻转，请你返回修改后的链表。
 *      * k是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *      * 不允许修改节点的值，而是需要œ实际进行节点交换。
 *      *
 *      * 输入：head = [1,2,3,4,5], k = 2
 *      * 输出：[2,1,4,3,5]
 *      *
 *      * 输入：head = [1,2,3,4,5], k = 3
 *      * 输出：[3,2,1,4,5]
 *
 **/
public class HaluoTest {


    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode p = a1;
        System.out.print("before reverse:");

        while(p != null){
            System.out.print(p.value + " ");
            p = p.next;
        }


        ListNode result = reverseList(a1, 3);
        System.out.print("after reverse:");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

    }


    public static ListNode reverseList(ListNode head, int k){

        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        // find k node
        for (int i = 0; i < k; i++) {
            if(curr == null){
                return head;
            }
            curr = curr.next;
        }
        // reverse subList
        ListNode newHead = reverse(head, curr);
        head.next = reverseList(curr, k);
        return newHead;

    }


    private static ListNode reverse(ListNode start, ListNode end){

        ListNode pre = null;
        ListNode next = null;
        while(start != end){
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }

        return pre;


    }

    static class ListNode{
        int value;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }


}