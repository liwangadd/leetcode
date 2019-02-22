package leetcode.T400_T500;

public class T430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node curNode = head;
        while (curNode != null) {
            if (curNode.child != null) {
                Node nextHead = curNode.next;
                curNode.next = curNode.child;
                curNode.child.prev = curNode;
                Node tmpNode = curNode.child;
                while (tmpNode.next != null) tmpNode = tmpNode.next;
                tmpNode.next = nextHead;
                if (nextHead != null)
                    nextHead.prev = tmpNode;
                curNode.child = null;
            }
            curNode = curNode.next;
        }
        return head;
    }

}
