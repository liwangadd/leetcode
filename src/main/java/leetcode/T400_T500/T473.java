package leetcode.T400_T500;

import javax.xml.transform.Source;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class T473 {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        return dfs(matchsticks, new int[4], matchsticks.length - 1, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int index, int target) {
        if (index == -1) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue;
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, index - 1, target)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T473().makesquare(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,102}));
    }

}
