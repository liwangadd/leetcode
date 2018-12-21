package leetcode.T1_T100;

public class T28 {

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0 || haystack.equals(needle)) return 0;
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int[] kmp = new int[needle.length()];
        kmp[0] = 0;
        int k = 0;
        for (int i = 1, len = needle.length(); i < len; ++i) {
            while (k > 0 && needleArr[i] != needleArr[k]) k = kmp[k - 1];
            kmp[i] = (k += (needleArr[i] == needleArr[k] ? 1 : 0));
        }
        k = 0;
        for (int i = 0, len1 = haystack.length(); i < len1; ++i) {
            while (k > 0 && haystackArr[i] != needleArr[k]) k = kmp[k - 1];
            if (haystackArr[i] == needleArr[k]) ++k;
            if (k == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }

}
