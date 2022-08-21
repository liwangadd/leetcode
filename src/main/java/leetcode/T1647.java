package leetcode;

public class T1647 {

    public int minDeletions(String s) {
        int[] counts = new int[26];
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        boolean[] existed = new boolean[maxCount + 1];
        int res = 0;
        for (int count : counts) {
            while (count > 0 && existed[count]) {
                ++res;
                --count;
            }
            if (count >= 0)
                existed[count] = true;
        }
        return res;
    }

}
