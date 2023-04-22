package leetcode;

public class T1456 {

    public int maxVowels(String s, int k) {
        int left = 0, right = 0, vowelCount = 0, maxVal = 0;
        while (right < k && right < s.length()) {
            if (isVowel(s.charAt(k++))) ++vowelCount;
        }
        maxVal = Math.max(vowelCount, maxVal);
        while (right < s.length()) {
            vowelCount += isVowel(s.charAt(right++)) ? 1 : 0;
            vowelCount -= isVowel(s.charAt(left++)) ? 1 : 0;
            maxVal = Math.max(maxVal, vowelCount);
        }
        return maxVal;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
