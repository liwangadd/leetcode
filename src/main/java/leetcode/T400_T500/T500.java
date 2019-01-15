package leetcode.T400_T500;

import java.util.*;

public class T500 {

    public String[] findWords(String[] words) {
        Set<Character> secondRow = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> thirdRow = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        Set<Character> firstRow = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 0) {
                Set<Character> rowSet;
                if (firstRow.contains(Character.toLowerCase(word.charAt(0)))) rowSet = firstRow;
                else if (secondRow.contains(Character.toLowerCase(word.charAt(0)))) rowSet = secondRow;
                else rowSet = thirdRow;
                boolean isRight = true;
                for (char c : word.toCharArray()) {
                    if (!rowSet.contains(Character.toLowerCase(c))) {
                        isRight = false;
                        break;
                    }
                }
                if (isRight) resList.add(word);
            }
        }
        return resList.toArray(new String[resList.size()]);
    }

}
