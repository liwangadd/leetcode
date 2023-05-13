package leetcode;

public class T2432 {

    public int hardestWorker(int n, int[][] logs) {
        int employeeId = logs[0][0], maxDuration = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int duration = logs[i][1] - logs[i - 1][1];
            if (duration > maxDuration) {
                maxDuration = logs[i][1] - logs[i - 1][1];
                employeeId = logs[i][0];
            } else if (duration == maxDuration) {
                employeeId = Math.min(employeeId, logs[i][0]);
            }
        }
        return employeeId;
    }

}
