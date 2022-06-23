package leetcode.T800_T900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T820 {

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); ++i) {
                set.remove(word.substring(i));
            }
        }
        return set.stream().map(String::length).mapToInt(i -> i).sum() + set.size();
    }

    public static void main(String[] args) {
        int res = new T820().minimumLengthEncoding(new String[]{"time", "me", "bell"});
        System.out.println(res);
    }

}
