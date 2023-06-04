package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1396 {

    class UndergroundSystem {

        private Map<String, Map<String, int[]>> timeMap;

        private Map<Integer, Tuple> cardMap;

        public UndergroundSystem() {
            this.timeMap = new HashMap<>();
            this.cardMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            cardMap.put(id, new Tuple(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Tuple checkInInfo = cardMap.get(id);
            String startStation = checkInInfo.stationName;
            int startTime = checkInInfo.time;
            if (!timeMap.containsKey(startStation)) timeMap.put(startStation, new HashMap<>());
            Map<String, int[]> targetMap = timeMap.get(startStation);
            if (!targetMap.containsKey(stationName)) targetMap.put(stationName, new int[2]);
            int[] values = targetMap.get(stationName);
            values[0] += t - startTime;
            values[1] += 1;
            cardMap.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            int[] values = timeMap.get(startStation).get(endStation);
            return 1.0 * values[0] / values[1];
        }

        private final class Tuple {
            private String stationName;
            private int time;

            public Tuple(String stationName, int time) {
                this.stationName = stationName;
                this.time = time;
            }
        }
    }

}
