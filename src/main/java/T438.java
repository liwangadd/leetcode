import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T438 {

    public static List<Integer> findAnagrams(String s, String p) {
        int[] flags1 = new int[26], flags2 = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            flags1[p.charAt(i) - 'a']++;
        }
        int left = 0, right = -1;
        List<Integer> res = new ArrayList<>();
        while (left < s.length()) {
            while (right < s.length() - 1 && flags2[s.charAt(right + 1) - 'a'] < flags1[s.charAt(right + 1) - 'a']) {
                ++right;
                flags2[s.charAt(right) - 'a']++;
            }
            if (Arrays.equals(flags1, flags2)) {
                res.add(left);
            }
            if (right == s.length() - 1) break;
            while (left < right && flags2[s.charAt(left) - 'a'] == 0) {
                ++left;
            }
            flags2[s.charAt(left++) - 'a']--;
        }
        return res;
    }

    public static void main(String[] args) {
        for (Integer index : findAnagrams("cbaebabacd", "abc")) {
            System.out.print(index);
        }
        System.out.println();

        for (Integer index : findAnagrams("abab", "ab")) {
            System.out.print(index);
        }
    }

}
