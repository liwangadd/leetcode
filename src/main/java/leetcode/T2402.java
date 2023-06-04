package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T2402 {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(m -> m[0]));
        int[] counters = new int[n];
        Queue<int[]> meetingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        Queue<Integer> roomQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) roomQueue.add(i);
        for (int[] meeting : meetings) {
            while (!meetingQueue.isEmpty() && meetingQueue.peek()[1] <= meeting[0]) {
                int[] prevMeeting = meetingQueue.poll();
                roomQueue.add(prevMeeting[0]);
            }
            if (!roomQueue.isEmpty()) {
                int room = roomQueue.poll();
                ++counters[room];
                meetingQueue.add(new int[]{room, meeting[1]});
            } else {
                int[] prevMeeting = meetingQueue.poll();
                ++counters[prevMeeting[0]];
                meetingQueue.add(new int[]{prevMeeting[0], prevMeeting[1] + meeting[1] - meeting[0]});
            }
        }
        int maxMeeting = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (counters[i] > maxMeeting) {
                maxMeeting = counters[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        new T2402().mostBooked(4,
                new int[][]{
                        {12,44},{27,37},{48,49},{46,49},{24,44},{32,38},{21,49},{13,30}
                });
    }

}
