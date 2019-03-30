package leetcode.T400_T500;

import leetcode.T200_T300.T288;

public class T408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        int lastIndex = 0;
        char[] wordArr = word.toCharArray();
        char[] abbrArr = abbr.toCharArray();
        for (int i = 0, abbrLen = abbrArr.length; i < abbrLen; ++i) {
            if (Character.isDigit(abbrArr[i])) {
                int count = abbrArr[i] - '0';
                if (count == 0) return false;
                while (i + 1 < abbrLen && Character.isDigit(abbrArr[i + 1])) {
                    count = count * 10 + abbrArr[++i] - '0';
                }
                lastIndex += count;
            } else {
                if (wordArr[lastIndex] != abbrArr[i]) return false;
                ++lastIndex;
            }
        }
        return lastIndex == wordArr.length;
    }

    public static void main(String[] args) {
        T408 solution = new T408();
        System.out.println(solution.validWordAbbreviation("internationalization", "i12iz4n"));
    }

}
