package leetcode.T300_T400;

public class T395 {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k < 0 || k > s.length()) return 0;
        char[] sArr = s.toCharArray();
        int[] charCounter = new int[26];
        int res = 0;
        for (char c : sArr)
            charCounter[c - 'a']++;
        boolean fullValid = true;
        for (int i = 0; i < 26; ++i) {
            if (charCounter[i] > 0 && charCounter[i] < k) {
                fullValid = false;
                break;
            }
        }
        if (fullValid) return s.length();
        int lastStart = 0;
        for (int i = 0, len = sArr.length; i < len; ++i) {
            if (charCounter[sArr[i] - 'a'] > 0 && charCounter[sArr[i] - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(lastStart, i), k));
                lastStart = i + 1;
            }
        }
        res = Math.max(res, longestSubstring(s.substring(lastStart, sArr.length), k));
        return res;
    }

    public static void main(String[] args) {
        T395 solution = new T395();
        System.out.println(solution.longestSubstring("aaabb", 3));
        System.out.println(solution.longestSubstring("bbaaacbd", 3));
        System.out.println(solution.longestSubstring("ababbc", 2));
    }

}
