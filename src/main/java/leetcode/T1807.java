package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> mapping = new HashMap<>();
        for (List<String> pair : knowledge) {
            mapping.put(pair.get(0), pair.get(1));
        }
        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        int startIndex = 0;
        for (int i = 0; i < sArr.length; ++i) {
            if (sArr[i] == '(') {
                startIndex = i;
            } else if (sArr[i] == ')') {
                String key = s.substring(startIndex + 1, i);
                String value = mapping.getOrDefault(key, "?");
                sb.append(value);
                startIndex = -1;
            }
        }
        return sb.toString();
    }

}
