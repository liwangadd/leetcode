package leetcode;

public class T2287 {

    public int rearrangeCharacters(String s, String target) {
        int[] targetCounts = new int[26];
        for (char c : target.toCharArray()) {
            ++targetCounts[c - 'a'];
        }
        int[] sCounts = new int[26];
        for (char c : s.toCharArray()) {
            ++sCounts[c - 'a'];
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (targetCounts[i] != 0) {
                count = Math.min(sCounts[i] / targetCounts[i], count);
            }
        }
        return count;
    }

    private boolean covered(int[] sCounts, int[] targetCounts) {
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] < targetCounts[i])
                return false;
        }
        return true;
    }

}
