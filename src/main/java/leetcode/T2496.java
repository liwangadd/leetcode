package leetcode;

public class T2496 {

    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs) {
            try {
                int num = Integer.parseInt(str);
                res = Math.max(res, num);
            } catch (NumberFormatException ignored) {
                res = Math.max(res, str.length());
            }
        }
        return res;
    }

}
