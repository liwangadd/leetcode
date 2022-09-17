package leetcode;

public class T2007 {

    public int[] findOriginalArray(int[] changed) {
        int len = changed.length, index = 0, maxVal = -1;
        if ((len & 1) == 1) return new int[0];
        for (int val : changed) {
            maxVal = Math.max(maxVal, val);
        }
        int[] freq = new int[maxVal + 1];
        int[] res = new int[len / 2];
        for (int val : changed) {
            ++freq[val];
        }
        for (int i = 0; i <= maxVal; i++) {
            if (freq[i] == 0) continue;
            if (2 * i > maxVal && freq[i] != 0 || freq[i] > freq[i + i]) return new int[0];
            for (int j = 0; j < freq[i]; j++) {
                res[index++] = i;
                --freq[i + i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T2007().findOriginalArray(new int[]{2,1,2,4,2,4});
    }

}
