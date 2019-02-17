package leetcode.T300_T400;

public class T318 {

    public int maxProduct(String[] words) {
        int[] values = new int[words.length];
        for (int i=0;i<words.length;++i) {
            for (int j = 0, len = words[i].length(); j < len; ++j) {
                values[i] |= 1 << (words[i].charAt(j) - 'a');
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
