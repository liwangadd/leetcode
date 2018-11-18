package T300_T400;

import java.util.*;

public class T336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        if (words.length == 0) return res;

        Map<String, Integer> map = new HashMap<>(words.length);
        for (int i = 0, len = words.length; i < len; ++i) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for (int i = 0, len = words.length; i < len; ++i) {
            for (int j = 0, len1 = words[i].length(); j < len1; ++j) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (map.containsKey(left) && !map.get(left).equals(i) && isPalindrome(right)) {
                    res.add(Arrays.asList(i, map.get(left)));
                    if (left.isEmpty()) {
                        res.add(Arrays.asList(map.get(left), i));
                    }
                }
                if (map.containsKey(right) && !map.get(right).equals(i) && isPalindrome(left)) {
                    res.add(Arrays.asList(map.get(right), i));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) {
        T336 solution = new T336();
        for (List<Integer> pair : solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }

}
