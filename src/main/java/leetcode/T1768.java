package leetcode;

public class T1768 {

    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray(), arr2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0, len1 = arr1.length, len2 = arr2.length;
        for (; i < len1 && i < len2; ++i) {
            sb.append(arr1[i]).append(arr2[i]);
        }
        if (i < arr1.length) {
            sb.append(arr1, i, len1 - i);
        } else {
            sb.append(arr2, i, len2 - i);
        }
        return sb.toString();
    }

}
