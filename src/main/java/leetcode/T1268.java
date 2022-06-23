package leetcode;

import leetcode.T300_T400.T347;
import sun.nio.cs.ext.TIS_620;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T1268 {

    private static class TreeNode {
        private final TreeNode[] children;
        private final List<String> vals;

        public TreeNode() {
            this.children = new TreeNode[26];
            this.vals = new LinkedList<>();
        }
    }

    private TreeNode root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.root = new TreeNode();
        Arrays.sort(products);
        for (String product : products) {
            char[] chars = product.toCharArray();
            TreeNode node = root;
            for (char c : chars) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TreeNode();
                node = node.children[c - 'a'];
                if (node.vals.size() < 3) node.vals.add(product);
            }
        }

        List<List<String>> res = new LinkedList<>();
        TreeNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            int index = searchWord.charAt(i) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
                res.add(node.vals);
            } else {
                break;
            }
        }
        while (res.size() < searchWord.length()) {
            res.add(Collections.emptyList());
        }
        return res;
    }

}
