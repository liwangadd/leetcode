package leetcode;

public class T1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = 0;
        int[] times = new int[n];
        for (int i = 0; i < manager.length; i++) {
            if (informTime[i] == 0) continue;
            maxTime = Math.max(maxTime, helper(manager[i], manager, informTime, times));
        }
        return maxTime;
    }

    private int helper(int index, int[] manager, int[] informTime, int[] times) {
        if (index == -1) return informTime[index];
        if (times[index] != 0) return times[index];
        return times[index] = informTime[index] + helper(manager[index], manager, informTime, times);
    }

}
