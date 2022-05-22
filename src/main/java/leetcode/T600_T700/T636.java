package leetcode.T600_T700;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class T636 {

    private static class Item {

        private int id;

        private int startTime;


        public Item(int id, int startTime) {
            this.id = id;
            this.startTime = startTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n <= 0 || logs == null || logs.isEmpty()) return new int[0];
        int[] res = new int[n];
        Stack<Item> stack = new Stack<>();
        for (String log : logs) {
            String[] parts = log.split(":");
            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek().id] += Integer.parseInt(parts[2]) - stack.peek().startTime;
                }
                stack.add(new Item(Integer.parseInt(parts[0]), Integer.parseInt(parts[2])));
            } else {
                Item startItem = stack.pop();
                res[startItem.id] += Integer.parseInt(parts[2]) - startItem.startTime + 1;
                if (!stack.isEmpty()) {
                    stack.peek().startTime = Integer.parseInt(parts[2]) + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T636().exclusiveTime(1, Lists.newArrayList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
    }

}
