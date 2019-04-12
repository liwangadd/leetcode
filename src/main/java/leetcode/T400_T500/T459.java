package leetcode.T400_T500;

public class T459 {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) return false;
        for (int i = 1; i < s.length(); ++i) {
            String subStr = s.substring(0, i);
            int prevPos = i;
            while (prevPos < s.length()) {
                if (s.startsWith(subStr, prevPos)) {
                    prevPos += subStr.length();
                } else {
                    break;
                }
            }
            if (prevPos == s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        T459 solution = new T459();
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
    }

}
