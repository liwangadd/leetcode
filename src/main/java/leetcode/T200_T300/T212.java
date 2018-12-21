package leetcode.T200_T300;

import java.util.LinkedList;
import java.util.List;

public class T212 {

    class TreeNode {
        String word;
        TreeNode children[] = new TreeNode[26];
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) return res;

        TreeNode root = buildWordTree(words);

        for (int i = 0, len = board.length; i < len; ++i) {
            for (int j = 0, len1 = board[0].length; j < len1; ++j) {
                findWords(board, i, j, root, res);
            }
        }
        return res;
    }

    private void findWords(char[][] board, int i, int j, TreeNode node, List<String> res) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) findWords(board, i - 1, j, node, res);
        if (i < board.length - 1) findWords(board, i + 1, j, node, res);
        if (j > 0) findWords(board, i, j - 1, node, res);
        if (j < board[0].length - 1) findWords(board, i, j + 1, node, res);
        board[i][j] = c;
    }

    private TreeNode buildWordTree(String[] words) {
        TreeNode root = new TreeNode();
        for (String word : words) {
            TreeNode current = root;
            char[] wordArr = word.toCharArray();
            for (int i = 0, len = word.length(); i < len; ++i) {
                if (current.children[wordArr[i] - 'a'] == null)
                    current.children[wordArr[i] - 'a'] = new TreeNode();
                current = current.children[wordArr[i] - 'a'];
            }
            current.word = word;
        }
        return root;
    }

}
