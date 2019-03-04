package leetcode.T400_T500;

import java.util.*;

public class T433 {

    public int minMutation(String start, String end, String[] bank) {

        char[] elements = {'A', 'C', 'T', 'G'};
        char[] endArr = end.toCharArray();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                String old = queue.poll();
                if (old.equals(end)) return res;
                char[] oldArr = old.toCharArray();
                for (int i = 0; i < oldArr.length; ++i) {
                    char oldChar = oldArr[i];
//                    if (oldArr[i] != endArr[i]) {
                    for (char element : elements) {
                        oldArr[i] = element;
                        String newStr = new String(oldArr);
                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                    oldArr[i] = oldChar;
//                    }

                }
            }
            ++res;
        }
        return -1;
    }

    public static void main(String[] args) {
        T433 solution = new T433();
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA"
                , new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC",
                new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(solution.minMutation("AACCTTGG", "AATTCCGG",
                new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"}));
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"}));
    }

}
