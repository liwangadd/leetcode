package leetcode.T1_T100;

import leetcode.utils.ListNode;

public class T92 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n || head == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode beforeTail = newHead;
        int index = 1;
        while (index < m) {
            beforeTail = beforeTail.next;
            ++index;
        }

        ListNode pre = beforeTail.next, current=null;
        ListNode middleTail = pre, nextHead=pre.next;
        for (; index < n; ++index) {
            current=nextHead;
            nextHead = nextHead.next;
            current.next = pre;
            pre = current;
        }
        beforeTail.next = current;
        middleTail.next = nextHead;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode newHead = reverseBetween(head, 2, 3);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }

}
