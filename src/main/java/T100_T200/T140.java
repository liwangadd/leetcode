package T100_T200;

import java.util.*;

public class T140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return new ArrayList<>();
        return DFS(s, wordDict, new HashMap<>());
    }

    private List<String> DFS(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String str : subList) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

}
