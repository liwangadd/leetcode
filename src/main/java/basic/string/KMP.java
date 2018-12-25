package basic.string;

public class KMP {

    private int[] getNext(String str) {
        char[] strArr = str.toCharArray();
        int len = str.length();
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || strArr[j] == strArr[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int indexOf(String source, String pattern) {
        char[] sourceArr = source.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int[] next = getNext(pattern);
        int j = 0, i = 0;
        while (i < source.length() && j < pattern.length()) {
            if (j == -1 || sourceArr[i] == patternArr[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) return i - j;
        else return -1;
    }

}
