package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] lengths = new int[words.length];
        char[][] wordChars = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            lengths[i] = 1;
            wordChars[i] = words[i].toCharArray();
            for (int j = i - 1; j >= 0; --j) {
                if (wordChars[j].length == wordChars[i].length - 1 && isPredecessor(wordChars[i], wordChars[j])) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                } else if (wordChars[j].length < wordChars[i].length - 1) {
                    break;
                }
            }
        }
        int res = 1;
        for (int length : lengths) {
            res = Math.max(res, length);
        }
        return res;
    }

    private boolean isPredecessor(char[] arr1, char[] arr2) {
        int i = 0, j = 0;
        boolean flag = true;
        for (; j < arr2.length; ++j) {
            if (arr1[i] == arr2[j]) ++i;
            else if (flag) {
                ++i;
                --j;
                flag = false;
            }
        }
        return (i + (flag ? 1 : 0) == arr1.length) && j == arr2.length;
    }

    public static void main(String[] args) {
//        boolean res = new T1048().isPredecessor("bcd".toCharArray(), "bd".toCharArray());
//        System.out.println(res);
        int res = new T1048().longestStrChain(new String[]{"a", "b", "ab", "bac"});
        System.out.println(res);
    }

}
