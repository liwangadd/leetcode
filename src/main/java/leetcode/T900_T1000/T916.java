package leetcode.T900_T1000;

import java.util.LinkedList;
import java.util.List;

public class T916 {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26], temp;
        for (String s : words2) {
            temp = counter(s);
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }
        List<String> res = new LinkedList<>();
        for (String s : words1) {
            temp = counter(s);
            int index = 0;
            for (; index < 26; ++index) {
                if (temp[index] < count[index])
                    break;
            }
            if (index == 26) res.add(s);
        }
        return res;
    }

    private int[] counter(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            ++res[c - 'a'];
        }
        return res;
    }

}
