package leetcode;

import javafx.scene.effect.Light;
import utils.TreeNode;

import java.awt.image.Kernel;
import java.util.Map;
import java.util.TreeMap;

public class T1530 {

    private int res;

    public int countPairs(TreeNode root, int distance) {
        res = 0;
        if (root == null) return res;
        leftDistance(root, distance);
        return res;
    }

    private TreeMap<Integer, Integer> leftDistance(TreeNode node, int distance) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (node.left == null && node.right == null) {
            map.put(1, 1);
            return map;
        }
        TreeMap<Integer, Integer> leftMap = new TreeMap<>(), rightMap = new TreeMap<>();
        if (node.left != null) {
            leftMap = leftDistance(node.left, distance);
        }
        if (node.right != null) {
            rightMap = leftDistance(node.right, distance);
        }
        for (Map.Entry<Integer, Integer> leftEntry : leftMap.entrySet()) {
            for (Map.Entry<Integer, Integer> rightEntry : rightMap.entrySet()) {
                if (leftEntry.getKey() + rightEntry.getKey() <= distance)
                    res += leftEntry.getValue() + rightEntry.getValue();
                else break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : leftMap.entrySet()) {
            if (entry.getKey() < distance - 1)
                map.put(entry.getKey() + 1, map.getOrDefault(entry.getKey() + 1, 0) + entry.getValue());
            else break;
        }
        for (Map.Entry<Integer, Integer> entry : rightMap.entrySet()) {
            if (entry.getKey() < distance - 1)
                map.put(entry.getKey() + 1, map.getOrDefault(entry.getKey() + 1, 0) + entry.getValue());
            else break;
        }
        return map;
    }

}
