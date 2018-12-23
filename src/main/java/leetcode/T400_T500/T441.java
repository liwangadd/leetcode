package leetcode.T400_T500;

public class T441 {

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2.0*n+0.25)-0.5);
    }

    public static void main(String[] args) {
        T441 solution = new T441();
        System.out.println(solution.arrangeCoins(100));
    }

}
