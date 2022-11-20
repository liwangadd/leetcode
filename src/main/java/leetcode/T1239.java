package leetcode;

import com.google.common.collect.Lists;

import java.util.List;

public class T1239 {

    private boolean[] visited;

    private int maxLen;

    public int maxLength(List<String> arr) {
        this.visited = new boolean[26];
        this.maxLen = 0;
        helper(arr, 0, 0);
        return maxLen;
    }

    private void helper(List<String> arr, int index, int len) {
        maxLen = Math.max(len, maxLen);
        if (index >= arr.size()) return;
        helper(arr, index + 1, len);
        char[] sArr = arr.get(index).toCharArray();
        boolean updated = true;
        for (int i = 0; i < sArr.length; i++) {
            if (visited[sArr[i] - 'a']) {
                for (int j = 0; j < i; ++j) visited[sArr[j] - 'a'] = false;
                updated = false;
                break;
            } else visited[sArr[i] - 'a'] = true;
        }
        if (updated) {
            helper(arr, index + 1, len + sArr.length);
            for (char c : sArr) visited[c - 'a'] = false;
        }
    }

    public static void main(String[] args) {
        new T1239().maxLength(Lists.newArrayList("un", "iq", "ue"));
    }

}
