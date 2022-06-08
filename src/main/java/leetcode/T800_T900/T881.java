package leetcode.T800_T900;

import java.util.Arrays;

public class T881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;
        while (left <= right) {
            ++res;
            if (people[left] + people[right] > limit) {
                --right;
            } else {
                --right;
                ++left;
            }
        }
        return res;
    }

}
