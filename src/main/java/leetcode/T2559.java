package leetcode;

public class T2559 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counts = new int[words.length + 1];
        for (int i = 0; i < words.length; ++i) {
            if (isVowelString(words[i])) counts[i + 1] = counts[i] + 1;
            else counts[i + 1] = counts[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = counts[queries[i][1] + 1] - counts[queries[i][0]];
        }
        return res;
    }

    private boolean isVowelString(String s) {
        char startChar = s.charAt(0), endChar = s.charAt(s.length() - 1);
        return (startChar == 'a' || startChar == 'e' || startChar == 'i' || startChar == 'o' || startChar == 'u') &&
                (endChar == 'a' || endChar == 'e' || endChar == 'i' || endChar == 'o' || endChar == 'u');
    }

}
