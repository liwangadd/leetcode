package leetcode.T300_T400;

public class T383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] flags = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++flags[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            --flags[ransomNote.charAt(i) - 'a'];
            if (flags[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

}
