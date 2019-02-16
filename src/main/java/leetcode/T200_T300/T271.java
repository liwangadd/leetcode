package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T271 {

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append(len).append("$").append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        int index, wordEnd = 0;
        List<String> res = new ArrayList<>();
        while ((index = str.indexOf("$", wordEnd)) != -1) {
            int len = Integer.valueOf(str.substring(wordEnd + 1, index));
            wordEnd = index + len + 1;
            res.add(str.substring(index + 1, wordEnd));
        }
        return res;
    }

}
