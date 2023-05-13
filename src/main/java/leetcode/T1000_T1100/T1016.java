package leetcode.T1000_T1100;

import java.util.HashSet;
import java.util.Set;

public class T1016 {

    public boolean queryString(String s, int n) {
        Set<Integer> holders = new HashSet<>();
        for (int start = 0, len = s.length(); start < len; ++start) {
            int num = 0;
            for (int end = start; end < len; ++end) {
                num = num * 2 + s.charAt(end) - '0';
                if (num > 0 && num <= n) {
                    if (holders.add(num) && holders.size() == n) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new T1016().queryString("0110", 3);
    }

}
