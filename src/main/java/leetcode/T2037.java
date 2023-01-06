package leetcode;

import java.util.Arrays;

public class T2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0, len = seats.length; i < len; ++i) {
            res += (Math.abs(seats[i] - students[i]));
        }
        return res;
    }

}
