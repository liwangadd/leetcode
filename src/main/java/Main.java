import utils.ListNode;

public class Main {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : nodeB;
            nodeB = nodeB != null ? nodeB.next : nodeA;
        }
        return nodeA;
    }

}
