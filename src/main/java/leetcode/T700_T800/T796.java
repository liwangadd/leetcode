package leetcode.T700_T800;

public class T796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            boolean allMatch = true;
            for (int j = 0; j < len; j++) {
                if (s.charAt((i + j) % len) != goal.charAt(j)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) return true;
        }
        return false;
    }

}
