package leetcode;

public class T2485 {

    public int pivotInteger(int n) {
        int sum = 0, middleSum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        for (int i = 1; i <= n; i++) {
            middleSum += i;
            if (((sum + i) & 1) == 0 && middleSum == (sum + i) / 2) return i;
        }
        return -1;
    }

}
