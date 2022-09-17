package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr2[0] - arr1[0];
            }
        });
        int count = 0, max = 0;
        for (int[] property : properties) {
            if (property[1] < max) ++count;
            max = Math.max(max, property[1]);
        }
        return count;
    }

    public static void main(String[] args) {
        int res = new T1996().numberOfWeakCharacters(new int[][]{
                {7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}
        });
        System.out.println(res);
    }

}
