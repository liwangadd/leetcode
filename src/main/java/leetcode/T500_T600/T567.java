package leetcode.T500_T600;

public class T567 {

    public boolean checkInclusion(String s1, String s2) {
        char[] sArr1 = s1.toCharArray();
        char[] sArr2 = s2.toCharArray();
        int[] holder1 = new int[26], holder2 = new int[26];
        for (char c : sArr1) {
            holder1[c - 'a']++;
        }
        int matchedCount = 0;
        int left = 0;
        for (int right = 0; right < sArr2.length; ++right) {
            int index = sArr2[right] - 'a';
            ++holder2[index];
            if (holder1[index] > 0) ++matchedCount;
            if (holder2[index] <= holder1[index]) {
                if (matchedCount == sArr1.length) {
                    return true;
                }
            } else {
                while (holder2[index] > holder1[index]) {
                    if (holder1[sArr2[left] - 'a'] > 0)
                        --matchedCount;
                    --holder2[sArr2[left++] - 'a'];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T567().checkInclusion("adc", "dcda"));
    }

}
