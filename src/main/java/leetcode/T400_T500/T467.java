package leetcode.T400_T500;

public class T467 {

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        int[] count = new int[26];
        int maxLength = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == 25)) {
                ++maxLength;
            } else {
                maxLength = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxLength);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }

}
