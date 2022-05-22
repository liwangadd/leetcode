package leetcode.T500_T600;

public class T526 {

    public int countArrangement(int n) {
        if (n <= 0) return 0;
        return helper(n, 1, new boolean[n + 1]);
    }

    private int helper(int n, int pos, boolean[] used) {
        if (pos >= used.length) return 1;
        int res = 0;
        for (int i = 1; i < used.length; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                res += helper(n, pos + 1, used);
                used[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T526().countArrangement(15));
    }

}
