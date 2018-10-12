package T1_T100;

public class T3 {

    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];

        int left = 0, right = -1;
        int res = 0;
        while (left < s.length()) {
            while (right < s.length() - 1 && map[s.charAt(right + 1)] == 0) {
                ++right;
                map[s.charAt(right)]++;
            }
            res = Math.max(res, right - left + 1);
            if (right == s.length() - 1) break;
            while (map[s.charAt(right + 1)] != 0) {
                map[s.charAt(left++)]--;
            }
        }
        return res;
//        int j = 0;
//        int i = 0;
//        int ans = 0;
//        for (; i < s.length(); i++) {
//            while (j < s.length() && map[s.charAt(j)] == 0) {
//                map[s.charAt(j)] = 1;
//                ans = Math.max(ans, j - i + 1);
//                j++;
//            }
//            map[s.charAt(i)] = 0;
//        }
//
//        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
