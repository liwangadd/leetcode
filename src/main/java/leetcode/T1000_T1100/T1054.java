package leetcode.T1000_T1100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        while (index < barcodes.length && !queue.isEmpty()) {
            int[] barcode = queue.poll();
            while (barcode[1]-- > 0) {
                res[index] = barcode[0];
                index += 2;
                if (index >= res.length) index = 1;
            }
        }
        return res;
    }

}
