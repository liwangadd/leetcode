package leetcode.T900_T1000;

import com.sun.deploy.config.WebStartConfig;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class T936 {

    public int[] movesToStamp(String stamp, String target) {
        char[] sArr = stamp.toCharArray(), tArr = target.toCharArray();
        List<Integer> poses = new ArrayList<>();
        boolean[] visited = new boolean[tArr.length];
        int stars = 0, sLen = sArr.length, tLen = tArr.length;
        while (stars < tLen) {
            boolean doneReplace = false;
            for (int i = 0; i <= tLen - sLen; ++i) {
                if (!visited[i] && canReplace(tArr, i, sArr)) {
                    doneReplace = true;
                    visited[i] = true;
                    poses.add(i);
                    stars += doReplace(tArr, i, sArr);
                }
            }
            if (!doneReplace) return new int[0];
        }
        int[] res = new int[poses.size()];
        for (int i = poses.size() - 1, j = 0; i >= 0; --i, ++j) {
            res[j] = poses.get(i);
        }
        return res;
    }

    private boolean canReplace(char[] tArr, int pos, char[] sArr) {
        int starCount = 0;
        for (int i = 0; i < sArr.length; ++i) {
            if (tArr[pos + i] == '*') ++starCount;
            else if (tArr[pos + i] != sArr[i]) return false;
        }
        return starCount != sArr.length;
    }

    private int doReplace(char[] tArr, int pos, char[] sArr) {
        int starCount = 0;
        for (int i = 0; i < sArr.length; ++i) {
            if (tArr[pos + i] != '*') {
                ++starCount;
                tArr[pos + i] = '*';
            }
        }
        return starCount;
    }

    public static void main(String[] args) {
        new T936().movesToStamp("abca", "aabcaca");
    }

}
