package leetcode.T800_T900;

public class T809 {

    public int expressiveWords(String s, String[] words) {
        int res = 0, sLen = s.length();
        char[] sArr = s.toCharArray();
        for (String word : words) {
            if (word.length() > s.length())
                continue;
            char lastChar = ' ';
            int lastCount = 0;
            boolean hasFill = false;
            int index = 0, wordIndex = 0;
            char[] wordArr = word.toCharArray();
            for (; index < sLen; ++index) {
                if (wordIndex < wordArr.length && wordArr[wordIndex] == sArr[index]) {
                    if (hasFill && lastCount < 3) break;
                    if (lastChar != wordArr[wordIndex]) lastCount = 0;
                    hasFill = false;
                    lastChar = sArr[index];
                    ++wordIndex;
                } else {
                    if (sArr[index] == lastChar) hasFill = true;
                    else break;
                }
                ++lastCount;
            }
            if (index == sLen && wordIndex == word.length() && (!hasFill || lastCount >= 3))
                ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        new T809().expressiveWords("heeellooo",
                new String[]{"hello", "hi", "helo"});
    }

}
