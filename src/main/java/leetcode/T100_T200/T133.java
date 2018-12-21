package leetcode.T100_T200;

import java.util.*;

public class T133 {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode copyCurNode = map.get(curNode);
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNode);
                    queue.add(neighbor);
                }
                copyCurNode.neighbors.add(map.get(neighbor));
            }
        }
        return copyNode;
    }

}
