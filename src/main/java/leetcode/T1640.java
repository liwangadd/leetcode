package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i]))
                return false;
            int[] piece = map.get(arr[i]);
            for (int j = 0; j < piece.length; ++j, ++i)
                if (piece[j] != arr[i])
                    return false;
        }
        return true;
    }

}
