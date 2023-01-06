package leetcode;

public class T2042 {

    public boolean areNumbersAscending(String s) {
        char[] sArr = s.toCharArray();
        int preNum = -1;
        for (int i = 0, len = sArr.length; i < len; ++i) {
            if (isNumber(sArr[i])) {
                int num = 0;
                while (i < len && sArr[i] != ' ') {
                    num = num * 10 + sArr[i++] - '0';
                }
                if (num <= preNum) return false;
                else preNum = num;
            }
        }
        return true;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
