package leetcode.T300_T400;

import java.util.HashMap;
import java.util.Map;

public class T340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k <= 0) return 0;
        int max = 0;
        Map<Character, Integer> hash = new HashMap<>();
        int left = 0, right = -1;
        while (right < s.length() - 1) {
            char c = s.charAt(++right);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
            while (hash.size() > k) {
                char c1 = s.charAt(left++);
                int count = hash.get(c1);
                if (count == 1) hash.remove(c1);
                else hash.put(c1, count - 1);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        T340 solution = new T340();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba", 3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("WORLD", 4));
    }

}
