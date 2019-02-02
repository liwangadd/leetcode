package leetcode.T200_T300;

public class T266 {

    public boolean canPermutePalindrome(String s) {
        int len = s.length();
        char[] sArr = s.toCharArray();
        int[] charCount = new int[26];
        for (int i = 0; i < len; ++i) {
            charCount[sArr[i] - 'a']++;
        }
        int odd = (len & 1) == 0 ? 0 : 1;
        for (int i = 0; i < 26; ++i) {
            if (charCount[i] % 2 == 1) {
                if (odd <= 0) return false;
                else --odd;
            }
        }
        return true;
    }

}
