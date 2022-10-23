package leetcode;

public class T1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int diff = 0, prevChar1 = 0, prevChar2 = 0;
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        for (int i = 0, len = arr1.length; i < len; ++i) {
            if (arr1[i] != arr2[i]) {
                ++diff;
                if (diff == 1) {
                    prevChar1 = arr1[i];
                    prevChar2 = arr2[i];
                } else if (prevChar1 != arr2[i] || prevChar2 != arr1[i]) return false;
            }
        }
        return diff == 2;
    }

}
