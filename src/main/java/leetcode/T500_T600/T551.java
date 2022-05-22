package leetcode.T500_T600;

public class T551 {

    public boolean checkRecord(String s) {
        if (s == null || s.length() < 1) return true;
        int absentCount = 0, lateCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A') {
                if (++absentCount >= 2) {
                    return false;
                }
                lateCount = 0;
            } else if (s.charAt(i) == 'L') {
                ++lateCount;
                if (lateCount >= 3) {
                    return false;
                }
            } else {
                lateCount = 0;
            }
        }
        return true;
    }

}
