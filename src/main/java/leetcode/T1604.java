package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int[] parsedKeyTime = new int[keyTime.length];
        for (int i = 0; i < keyTime.length; ++i) {
            String[] parts = keyTime[i].split(":");
            parsedKeyTime[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        Integer[] orders = new Integer[keyName.length];
        for (int i = 0; i < keyName.length; i++) {
            orders[i] = i;
        }
        Arrays.sort(orders, (o1, o2) -> {
            if (keyName[o1].equals(keyName[o2])) return parsedKeyTime[o1] - parsedKeyTime[o2];
            else return keyName[o1].compareTo(keyName[o2]);
        });
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> mapping = new HashMap<>();
        for (Integer index : orders) {
            if (!mapping.containsKey(keyName[index])) {
                List<Integer> keyTimes = new ArrayList<>();
                keyTimes.add(parsedKeyTime[index]);
                mapping.put(keyName[index], keyTimes);
            } else {
                List<Integer> keyTimes = getItemsWithHour(mapping.get(keyName[index]), parsedKeyTime[index]);
                mapping.put(keyName[index], keyTimes);
                if (keyTimes.size() >= 3 && (ans.isEmpty() || !ans.get(ans.size() - 1).equals(keyName[index]))) {
                    ans.add(keyName[index]);
                }
            }
        }
        return ans;
    }

    private List<Integer> getItemsWithHour(List<Integer> prevKeyTimes, int keyTime) {
        List<Integer> newKeyTimes = new ArrayList<>();
        for (Integer prevKeyTime : prevKeyTimes) {
            if (keyTime - prevKeyTime <= 60) {
                newKeyTimes.add(prevKeyTime);
            }
        }
        newKeyTimes.add(keyTime);
        return newKeyTimes;
    }

}
