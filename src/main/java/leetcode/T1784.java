package leetcode;

public class T1784 {

    public boolean checkOnesSegment(String s) {
        char lastChar = '1';
        for (char c : s.toCharArray()) {
            if (c == '1' && lastChar == '0')
                return false;
            lastChar = c;
        }
        return true;
    }

}
