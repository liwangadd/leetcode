package leetcode.T900_T1000;

public class T921 {

    public int minAddToMakeValid(String s) {
        int res = 0, unMatched = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++unMatched;
            else if (c == ')') {
                if (unMatched == 0) ++res;
                else --unMatched;
            }
        }
        return res + unMatched;
    }

}
