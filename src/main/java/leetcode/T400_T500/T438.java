package leetcode.T400_T500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pChar = new int[26];

        for (int i = 0; i < p.length(); i++) {

            pChar[p.charAt(i) - 'a']++;
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            pChar[s.charAt(i) - 'a']--;

            while (pChar[s.charAt(i) - 'a'] < 0) pChar[s.charAt(j++) - 'a']++;

            if (i - j + 1 == p.length()) res.add(j);

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
