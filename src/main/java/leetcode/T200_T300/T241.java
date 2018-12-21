package leetcode.T200_T300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T241 {

    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < input.length(); ++i) {
            char operate = input.charAt(i);
            if (operate == '-' || operate == '+' || operate == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (operate) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }

    public static void main(String[] args) {
        T241 solution = new T241();
        for (Integer res : solution.diffWaysToCompute("2-1-1")) {
            System.out.println(res);
        }
        for (Integer res : solution.diffWaysToCompute("2*3-4*5")) {
            System.out.println(res);
        }
    }

}
