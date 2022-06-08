package leetcode.T700_T800;

import java.util.*;

public class T752 {

    private class Node {
        private String str;
        private int dis;

        public Node(String str, int dis) {
            this.str = str;
            this.dis = dis;
        }
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        int minDistance = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("0000", 0));
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            if (oldNode.str.equals(target)) {
                minDistance = oldNode.dis;
                break;
            }
            char[] oldStrArr = oldNode.str.toCharArray();
            for (int i = 0; i < 4; ++i) {
                char oldChar = oldStrArr[i];
                char newChar = (char) (oldChar + 1);
                if (oldChar == '9') newChar = '0';
                oldStrArr[i] = newChar;
                String newStr = new String(oldStrArr);
                if (visited.add(newStr) && !deadSet.contains(newStr)) {
                    queue.add(new Node(newStr, oldNode.dis + 1));
                }
                newChar = (char) (oldChar - 1);
                if (oldChar == '0') newChar = '9';
                oldStrArr[i] = newChar;
                newStr = new String(oldStrArr);
                if (visited.add(newStr) && !deadSet.contains(newStr)) {
                    queue.add(new Node(newStr, oldNode.dis + 1));
                }
                oldStrArr[i] = oldChar;
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
//        T752 solution = new T752();
//        System.out.println(solution.openLock(new String[]{"0000"}, "8888"));
    }

}
