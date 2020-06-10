package leetcode.T500_T600;

public class T541 {

    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int pos = 0;
        while (pos < s.length()) {
            int start = pos;
            int end = pos + k - 1;
            if (end >= s.length()) {
                end = s.length() - 1;
            }
            reverse(sArr, start, end);
            pos += 2 * k;
        }
        return new String(sArr);
    }

    private void reverse(char[] sArr, int start, int end) {
        while (start < end) {
            char tmp = sArr[start];
            sArr[start++] = sArr[end];
            sArr[end--] = tmp;
        }
    }

}
