package leetcode.T400_T500;

public class T495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int[] time = new int[timeSeries.length + 1];
        System.arraycopy(timeSeries, 0, time, 0, timeSeries.length);
        time[time.length - 1] = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < time.length - 1; ++i) {
            res += Math.min(time[i + 1] - time[i], duration);
        }
        return res;
    }

}
