package leetcode.T400_T500;

import java.util.Arrays;

public class T475 {

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null || houses.length == 0 || heaters.length == 0) return 0;
        Arrays.sort(heaters);
        int minRadius = Integer.MAX_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) index = -index - 1;
            int dis1 = index == 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
            int dis2 = index == heaters.length ? Integer.MAX_VALUE : heaters[index] - house;
            minRadius = Math.min(minRadius, Math.min(dis1, dis2));
        }
        return minRadius;
    }

}
