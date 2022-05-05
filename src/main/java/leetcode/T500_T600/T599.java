package leetcode.T500_T600;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> key2Index = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            key2Index.put(list1[i], i);
        }
        List<String> res = new LinkedList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            String s = list1[i];
            if (key2Index.containsKey(s)) {
                if (i + key2Index.get(s) < minIndexSum) {
                    minIndexSum = i + key2Index.get(s);
                    res.clear();
                    res.add(s);
                } else if (i + key2Index.get(s) == minIndexSum) {
                    res.add(s);
                }
            }
        }
        return res.toArray(new String[0]);
    }

}
