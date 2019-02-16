package leetcode.T300_T400;

import java.util.ArrayList;
import java.util.List;

public class T320 {

    private List<String> res;

    public List<String> generateAbbreviations(String word) {
        res = new ArrayList<>();
        if (word == null || word.length() == 0) return res;
        helper(word, 0);
        return res;
    }

    private void helper(String word, int pos) {
        if (pos >= word.length()) {
            res.add(word);
            return;
        }
        helper(word, pos+1);
        int index = pos;
        if (index > 0 && Character.isDigit(word.charAt(index - 1))) ++index;
        String prefix = word.substring(0, index);
        for (int i = 1; i + index <= word.length(); ++i) {
            String len = String.valueOf(i);
            helper(prefix + len + word.substring(index + i ), index + len.length() + 1);
        }
    }

    public static void main(String[] args) {
        T320 solution = new T320();
        for (String word : solution.generateAbbreviations("word")) {
            System.out.println(word);
        }
    }

}
