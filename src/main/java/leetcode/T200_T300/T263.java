package leetcode.T200_T300;

public class T263 {

    public boolean isUgly(int num) {
        if (num == 0) return false;
        int[] arr = new int[]{2, 3, 5};
        for (int anArr : arr) {
            while (num % anArr == 0) {
                num /= anArr;
            }
        }
        return num == 1;
    }

}
