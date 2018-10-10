import java.util.Arrays;
import java.util.Comparator;

public class T134 {

    private class Node {
        int gas;
        int cost;
        int index;

        public Node(int gas, int cost, int index) {
            this.gas = gas;
            this.cost = cost;
            this.index = index;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        Node[] stations = new Node[gas.length];
        for (int i = 0; i < gas.length; ++i) {
            stations[i] = new Node(gas[i], cost[i], i);
        }

        Arrays.sort(stations, Comparator.comparingInt(o -> o.gas - o.cost));
        int currentGas = 0;
        for (int i = 0; i < stations.length - 1; ++i) {
            currentGas += stations[i].gas;
            if (currentGas < stations[i + 1].cost) return -1;
            currentGas -= stations[i].cost;
        }
        return stations[0].index;
    }

}
