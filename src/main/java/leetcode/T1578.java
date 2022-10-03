package leetcode;

public class T1578 {

    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int partSumCost = 0, partMaxCost = 0, partCount = 0;
        int index = -1, len = colors.length();
        while (++index < len) {
            partSumCost = partMaxCost = neededTime[index];
            partCount = 1;
            while (index + 1 < len && colors.charAt(index + 1) == colors.charAt(index)) {
                partSumCost += neededTime[++index];
                partMaxCost = Math.max(partMaxCost, neededTime[index]);
                ++partCount;
            }
            if (partCount > 1) {
                minCost += partSumCost - partMaxCost;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        new T1578().minCost("baab", new int[]{8, 7, 2, 10});
    }

}
