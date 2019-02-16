package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T244 {

    public class WordDistance {

        private Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    map.get(words[i]).add(i);
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    map.put(words[i], item);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int min = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
                min = Math.min(min, Math.abs(i - j));
                if (list1.get(i) < list2.get(j)) {
                    ++i;
                } else {
                    ++j;
                }
            }
            return min;
        }
    }

}
