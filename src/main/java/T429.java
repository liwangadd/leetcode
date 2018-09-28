import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T429 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Node> nodes = new LinkedList<>();
        int count = 1;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int currentCount = count;
            count = 0;
            List<Integer> resItem = new LinkedList<>();
            while (currentCount-- > 0) {
                Node node = nodes.poll();
                resItem.add(node.val);
                for (Node child : node.children) {
                    nodes.add(child);
                    ++count;
                }
            }
            res.add(resItem);
        }
        return res;
    }

}
