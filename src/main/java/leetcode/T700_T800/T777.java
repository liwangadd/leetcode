package leetcode.T700_T800;

import java.util.Arrays;

public class T777 {

    // XL -> LX, RX -> XR
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        int LCount = 0, RCount = 0, len = start.length();
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) == 'L') ++LCount;
            if (end.charAt(i) == 'L') --LCount;
            if (LCount > 0) return false;
        }
        for (int i = len - 1; i >= 0; --i) {
            if (start.charAt(i) == 'R') ++RCount;
            if (end.charAt(i) == 'R') --RCount;
            if (RCount > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new T777().canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
//        System.out.println(new T777().canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
    }

}
