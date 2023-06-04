package leetcode;

public class T1156 {

    public int maxRepOpt1(String text) {
        int[] charCount = new int[26];
        for (char c : text.toCharArray()) ++charCount[c - 'a'];
        int maxRep = 0;
        for (int i = 0, len = text.length(); i < len; ) {
            char c = text.charAt(i);
            int j = i;
            while (j < len && text.charAt(j) == c) ++j;
            j -= 1;
            maxRep = Math.max(maxRep, j - i + 1);
            if (charCount[c - 'a'] > j - i + 1) {
                int k = j + 2;
                for (; k < len && text.charAt(k) == c && charCount[c - 'a'] > k - i; ++k) ;
                if (k <= len) maxRep = Math.max(maxRep, k - i);
                k = i - 2;
                for (; k >= 0 && text.charAt(k) == c && charCount[c - 'a'] > j - k; --k) ;
                if (k >= -1) maxRep = Math.max(maxRep, j - k);
            }
            i = j + 1;
        }
        return maxRep;
    }

    public static void main(String[] args) {
        new T1156().maxRepOpt1("abcdef");
    }

}
