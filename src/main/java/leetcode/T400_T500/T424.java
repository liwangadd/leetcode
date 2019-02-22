package leetcode.T400_T500;

public class T424 {

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, right = 0;
        int maxCount = 0, maxLength = 0;
        while (right < s.length()) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                --counts[s.charAt(left) - 'A'];
                ++left;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
