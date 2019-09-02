package leetcode.T400_T500;

import java.util.*;

public class T472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> prevWords = new HashSet<>();
        prevWords.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            if (isConcatenatedWord(words[i], prevWords)) {
                res.add(words[i]);
            }
            prevWords.add(words[i]);
        }
        return res;
    }

    private boolean isConcatenatedWord(String word, Set<String> prevWords) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                String subWord = word.substring(j, i);
                if (prevWords.contains(subWord) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

}
