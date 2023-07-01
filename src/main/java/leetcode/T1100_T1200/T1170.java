package leetcode.T1100_T1200;

import java.util.Map;
import java.util.TreeMap;

public class T1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        Map<Integer, Integer> wordFreq = new TreeMap<>((k1, k2) -> k2 - k1);
        for (String word : words) {
            int freq = calcFreq(word);
            wordFreq.put(freq, wordFreq.getOrDefault(freq, 0) + 1);
        }
        int[] res = new int[queries.length];
        int index = 0;
        for (String query : queries) {
            int freq = calcFreq(query);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : wordFreq.entrySet()) {
                if (freq < entry.getKey()) count += entry.getValue();
                else break;
            }
            res[index++] = count;
        }
        return res;
    }

    private int calcFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            ++freq[c - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return freq[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        new T1170().numSmallerByFrequency(
                new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"}
        );
    }

}
