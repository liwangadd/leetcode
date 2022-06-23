package leetcode.T700_T800;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class T745 {

    private static class TreeNode {
        private final TreeNode[] children;
        private final TreeSet<Integer> wordIndexes;

        public TreeNode() {
            this.children = new TreeNode[26];
            this.wordIndexes = new TreeSet<>();
        }
    }

    private final TreeNode prefixRoot;
    private final TreeNode suffixRoot;

    private Map<String, Integer> cache;

    public T745(String[] words) {
        prefixRoot = new TreeNode();
        suffixRoot = new TreeNode();
        cache = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            char[] word = words[i].toCharArray();
            TreeNode node = prefixRoot;
            for (char c : word) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TreeNode();
                node = node.children[c - 'a'];
                node.wordIndexes.add(i);
            }
            node = suffixRoot;
            for (int j = word.length - 1; j >= 0; --j) {
                char c = word[j];
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TreeNode();
                node = node.children[c - 'a'];
                node.wordIndexes.add(i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        if (cache.containsKey(prefix + "#" + suffix)) return cache.get(prefix + "#" + suffix);
        TreeSet<Integer> prefixSet, suffixSet;
        TreeNode node = prefixRoot;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] != null) node = node.children[prefix.charAt(i) - 'a'];
            else return -1;
        }
        prefixSet = node.wordIndexes;
        node = suffixRoot;
        for (int i = suffix.length() - 1; i >= 0; --i) {
            if (node.children[suffix.charAt(i) - 'a'] != null) node = node.children[suffix.charAt(i) - 'a'];
            else return -1;
        }
        suffixSet = node.wordIndexes;
        Iterator<Integer> iter = suffixSet.descendingIterator();
        while (iter.hasNext()) {
            Integer index = iter.next();
            if (prefixSet.contains(index)) {
                cache.put(prefix + "#" + suffix, index);
                return index;
            }
        }
        return -1;
    }

}
