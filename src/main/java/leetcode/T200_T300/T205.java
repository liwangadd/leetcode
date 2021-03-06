package leetcode.T200_T300;

import java.util.*;

public class T205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) - s.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                if (list.contains(t.charAt(i))) return false;
                else {
                    map.put(s.charAt(i), t.charAt(i) - s.charAt(i));
                    list.add(t.charAt(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T205 solution = new T205();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
    }

}
