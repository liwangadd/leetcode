package leetcode;

public class T1539 {

    public int findKthPositive(int[] arr, int k) {
        int arrayIndex = 0, curNum = 1;
        while (k-- > 0) {
            if (arrayIndex < arr.length && arr[arrayIndex] == curNum) {
                ++k;
                ++arrayIndex;
            }
            ++curNum;
        }
        return curNum;
    }

}
