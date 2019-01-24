package leetcode.T300_T400;

public class T397 {

    public int integerReplacement(int n) {
        long t = n;
        int res = 0;
        while (t > 1) {
            ++res;
            if ((t & 1) != 1) {
                t >>= 1;
            } else {
                if ((t & 2) != 0 && (t != 3)) ++t;
                else --t;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T397 solution = new T397();
        System.out.println(solution.integerReplacement(2147483647));
    }

}
