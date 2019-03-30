package leetcode.T300_T400;

public class T389 {

    public char findTheDifference(String s, String t) {
        int[] flags = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++flags[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < t.length(); ++i) {
            if (flags[t.charAt(i) - 'a'] == 0) return t.charAt(i);
            --flags[t.charAt(i) - 'a'];
        }
        return 'a';
    }

    public char findTheDifference1(String s, String t) {
        char c = t.charAt(0);
        for (int i = 0; i < s.length(); ++i) c ^= s.charAt(i);
        for (int i = 1; i < t.length(); ++i) c ^= t.charAt(i);
        return c;
    }

}
