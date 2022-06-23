package leetcode.T700_T800;

import java.util.LinkedList;
import java.util.Queue;

public class T720 {

    private static TrieNode root;
    private static final int size = 26;

    class TrieNode{
        TrieNode[] children = new TrieNode[size];
        String word;

        public TrieNode(){
            this.word = "";
        }
    }
    private void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            int index = c-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i =25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].word!=null && curr.children[i].word.length() != 0){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }

}
