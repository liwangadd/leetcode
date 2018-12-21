package leetcode.T100_T200;

public class T138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode current = head;
        while (current != null) {
            RandomListNode copyNode = new RandomListNode(current.label);
            RandomListNode nextNode = current.next;
            current.next = copyNode;
            copyNode.next = nextNode;
            current = nextNode;
        }

        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            else
                current.next.random = null;
            current = current.next.next;
        }

        current = head;
        RandomListNode copyHead = head.next;
        RandomListNode copyCurrent = copyHead;
        while (current != null) {
            current.next = current.next.next;
            if (copyCurrent.next != null)
                copyCurrent.next = copyCurrent.next.next;
            else
                copyCurrent.next = null;
            current = current.next;
            copyCurrent = copyCurrent.next;
        }
        return copyHead;
    }

}
