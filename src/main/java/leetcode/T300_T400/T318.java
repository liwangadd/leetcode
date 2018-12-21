package leetcode.T300_T400;

public class T318 {

    public int maxProduct(String[] words) {
        int[] values = new int[words.length];
        for (String word : words) {
            for (int i = 0, len = word.length(); i < len; ++i) {
                values[i] |= i << (word.charAt(i) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if ((values[i] & values[j]) == 0 && words[i].length() * words[j].length() > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }

}
