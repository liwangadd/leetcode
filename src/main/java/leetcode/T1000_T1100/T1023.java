package leetcode.T1000_T1100;

import java.util.ArrayList;
import java.util.List;

public class T1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (String query : queries) {
            ans.add(isMatch(query, pattern));
        }
        return ans;
    }

    public Boolean isMatch(String query, String pattern) {
        int index = 0;
        for (char c : query.toCharArray()) {
            if (index == pattern.length()) {
                if (c < 'a' || c > 'z') {
                    return false;
                }
            } else {
                if (c == pattern.charAt(index)) {
                    index ++ ;
                } else if (c < 'a' || c > 'z') {
                    return false;
                }
            }
        }
        return index == pattern.length();
    }

}
