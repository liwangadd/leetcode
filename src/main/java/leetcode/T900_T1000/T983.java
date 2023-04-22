package leetcode.T900_T1000;

import java.util.Arrays;

public class T983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] minCosts = new int[days[days.length - 1] + 31];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[0] = 0;
        int dayIndex = 0;
        for (int i = 1; i < 366 & dayIndex < days.length; ++i) {
            if (i == days[dayIndex]) {
                int day1 = i > 0 ? minCosts[i - 1] + costs[0] : costs[0];
                int day7 = i > 7 ? minCosts[i - 7] + costs[1] : costs[1];
                int day30 = i > 30 ? minCosts[i - 30] + costs[2] : costs[2];
                minCosts[i] = Math.min(day1, Math.min(day7, day30));
                ++dayIndex;
            } else {
                minCosts[i] = minCosts[i - 1];
            }
        }
        return minCosts[days[days.length - 1]];
    }

    public static void main(String[] args) {
        new T983().mincostTickets(
                new int[]{1, 4, 6, 7, 8, 2},
                new int[]{2, 7, 15}
        );
    }

}
