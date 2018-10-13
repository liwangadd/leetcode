package T300_T400;

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

}
