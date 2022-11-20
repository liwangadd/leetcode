package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class T2136 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<int[]> arr = new ArrayList<>();
        int size = plantTime.length;
        for (int i = 0; i < size; i++) {
            arr.add(new int[]{plantTime[i], growTime[i]});
        }
        arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int maxPlantTime = 0, maxDuration = 0;
        for (int i = 0; i < size; i++) {
            int[] pair = arr.get(i);
            maxDuration = Math.max(maxDuration, maxPlantTime + pair[0] + pair[1]);
            maxPlantTime += pair[0];
        }
        return maxDuration;
    }

}
