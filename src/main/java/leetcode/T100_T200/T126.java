package leetcode.T100_T200;

import java.util.*;

public class T126 {

    private List<List<String>> results;
    List<String> list;
    private Map<String, List<String>> map;

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results = new ArrayList<>();
        if (dict.size() == 0)
            return results;

        int curr = 1, next = 0;
        boolean found = false;
        list = new LinkedList<>();
        map = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> unvisited = new HashSet<>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (unvisited.contains(new_word)) {
                        //Handle queue
                        if (visited.add(new_word)) {//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else {
                            List<String> l = new LinkedList<>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(end) && !found) found = true;

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end, start);

        return results;
    }

    private void backTrace(String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start);
        list.remove(0);
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
