package sword;

import java.util.Arrays;

public class Fibonacci {

    // 简单斐波那契数列
    public int fibonacci(int n) {
        if (n <= 1) return n;
        int first = 0, second = 1;
        for (int i = 2; i <= n; ++i) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    // 跳台阶问题
    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int jumpFloor(int n) {
        if (n < 2) return n;
        int first = 1, second = 2;
        for (int i = 2; i < n; ++i) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    // 矩形覆盖问题
    // 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
    public int rectCover(int n) {
        if (n < 2) return n;
        int first = 1, second = 2;
        for (int i = 2; i < n; ++i) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    // 变态跳台阶问题
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int jumpFloor2(int target){
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    // f(n-1) = f(n-2) + f(n-3) + ... + f(0)
    // f(n) = f(n-1) + f(n-2) + ... + f(0)
    // f(n) - f(n-1) = f(n-1)
    // f(n) = 2 * f(n-1)
    public int jumpFloor2_2(int target){
        return (int) Math.pow(2, target - 1);
    }

}
