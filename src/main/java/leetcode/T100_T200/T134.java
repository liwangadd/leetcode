package leetcode.T100_T200;

public class T134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int index = 0;
        for (int i = 0; i < gas.length; ++i) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                index = i+1;
            }
            total += gas[i] - cost[i];
        }
        if (total < 0) return -1;
        return index;
    }

}
