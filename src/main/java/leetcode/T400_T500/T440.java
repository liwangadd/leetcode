package leetcode.T400_T500;

public class T440 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        while (--k != 0) {
            if (cur * 10 <= n) cur *= 10;
            else if (cur + 1 <= n) cur += 1;
            else {
                while (cur / 10 != 0 && cur % 10 == 9) cur /= 10;
                cur += 1;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        T440 solution = new T440();
        System.out.println(solution.findKthNumber(13, 2));
    }

}
