package leetcode.T1200_T1300;

import sun.awt.geom.AreaOp;

public class T1249 {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb1 = new StringBuilder();
        char[] sArr = s.toCharArray();
        int count = 0;
        for (char c : sArr) {
            if (c == '(') ++count;
            else if (c == ')') --count;
            if (count >= 0) sb1.append(c);
            count = Math.max(0, count);
        }
        StringBuilder sb2 = new StringBuilder();
        count = 0;
        for (int i = sb1.length() - 1; i >= 0; --i) {
            if (sb1.charAt(i) == ')') ++count;
            else if (sb1.charAt(i) == '(') --count;
            if (count >= 0) sb2.insert(0, sb1.charAt(i));
            count = Math.max(0, count);
        }
        return sb2.toString();
    }

}
