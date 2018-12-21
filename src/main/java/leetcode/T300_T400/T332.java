package leetcode.T300_T400;

import java.util.*;

public class T332 {

    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        if (tickets.length == 0) return res;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs(graph, "JFK", res);
        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String city, List<String> res) {
        if (graph.containsKey(city)) {
            while (!graph.get(city).isEmpty())
                dfs(graph, graph.get(city).poll(), res);

        }
        res.add(0, city);
    }
}
