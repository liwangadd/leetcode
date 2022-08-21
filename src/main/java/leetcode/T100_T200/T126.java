package leetcode.T100_T200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class T126 {

    private List<List<String>> res;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Set<String> visited = new HashSet<>(), unvisited = new HashSet<>(wordList);
        Map<String, List<String>> prev = new HashMap<>();

        if (!unvisited.contains(endWord)) return res;
        unvisited.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            while (count-- > 0) {
                String prevWord = queue.poll();
                StringBuilder sb = new StringBuilder(prevWord);
                for (int i = 0, len = sb.length(); i < len; ++i) {
                    char oldChar = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        sb.setCharAt(i, c);
                        String newWord = sb.toString();
                        if (unvisited.contains(newWord)) {
                            visited.add(newWord);
                            prev.computeIfAbsent(newWord, k->new LinkedList<>()).add(prevWord);
                        }
                    }
                    sb.setCharAt(i, oldChar);
                }
            }
            if (visited.contains(endWord)) {
                backtrace(beginWord, endWord, prev, new LinkedList<>());
                break;
            }
            count = visited.size();
            unvisited.removeAll(visited);
            queue.addAll(visited);
            visited.clear();
        }
        return res;
    }

    private void backtrace(String beginWord, String endWord, Map<String, List<String>> prev, LinkedList<String> path) {
        path.addFirst(endWord);
        if (endWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
        } else {
            List<String> words = prev.get(endWord);
            for (String word : words) {
                backtrace(beginWord, word, prev, path);
            }
        }
        path.removeFirst();
    }

    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        List<List<String>> res = new T126().findLadders("hit", "cog", wordList);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
