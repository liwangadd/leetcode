package leetcode.T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        generateIp(s, 0, res, "", 0);
        return res;
    }

    private static void generateIp(String s, int pos, List<String> res, String ip, int count) {
        if (count > 4) return;
        for (int i = 1; i <= 3 && pos + i <= s.length(); ++i) {
            Integer ipRange = Integer.valueOf(s.substring(pos, pos + i));
            if (ipRange <= 255) {
                if (pos + i >= s.length() && count == 3) {
                    res.add(ip + ipRange);
                    return;
                } else {
                    generateIp(s, pos + i, res, ip + ipRange + ".", count + 1);
                    if (ipRange == 0) return;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (String s : restoreIpAddresses("25525511135")) {
            System.out.println(s);
        }
    }
}
