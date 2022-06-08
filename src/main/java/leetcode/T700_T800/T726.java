package leetcode.T700_T800;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class T726 {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        while (index < formula.length()) {
            char c = formula.charAt(index++);
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (c == ')') {
                int count = 0;
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    count = count * 10 + formula.charAt(index++) - '0';
                }
                count = count == 0 ? 1 : count;
                Map<String, Integer> tmpMap = stack.pop();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    tmpMap.put(entry.getKey(), tmpMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
                map = tmpMap;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
                    sb.append(formula.charAt(index++));
                }
                int count = 0;
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    count = count * 10 + formula.charAt(index++) - '0';
                }
                count = count == 0 ? 1 : count;
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + count);
            }
        }
        List<String> atoms = map.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String atom : atoms) {
            sb.append(atom).append(map.get(atom) == 1 ? "" : map.get(atom));
        }
        return sb.toString();
    }

}
