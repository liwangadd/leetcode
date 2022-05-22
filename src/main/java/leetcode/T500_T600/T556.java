package leetcode.T500_T600;

import java.util.Arrays;

public class T556 {

    public int nextGreaterElement(int n) {
        char[] sArr = String.valueOf(n).toCharArray();
        int index = sArr.length - 2;
        for (; index >= 0; --index) {
            if (sArr[index] < sArr[index + 1]) {
                break;
            }
        }
        if (index == -1) return -1;
        int targetIndex = index + 1;
        for (int i = index; i < sArr.length; ++i) {
            if (sArr[i] < sArr[targetIndex] && sArr[i] > sArr[index]) {
                targetIndex = i;
            }
        }
        char temp = sArr[index];
        sArr[index] = sArr[targetIndex];
        sArr[targetIndex] = temp;
        Arrays.sort(sArr, index + 1, sArr.length);
        long res = Long.parseLong(new String(sArr));
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }

}
