package leetcode.T500_T600;

public class T520 {

    public boolean detectCapitalUse(String word) {
        char[] wordArr = word.toCharArray();
        int count = 0;
        for (char w : wordArr) {
            if (Character.isUpperCase(w)) {
                ++count;
            }
        }
        return count == word.length() || count == 0 || count == 1 && Character.isUpperCase(wordArr[0]);
    }

}
