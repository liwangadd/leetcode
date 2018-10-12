package T1_T100;

public class T60 {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] nums = new boolean[n + 1];
        k--;
        for (int i = 0; i < n; ++i) {
            if (k <= 0) break;
            int fac = factorial(n - i - 1);
            int res = k / fac + 1;
            System.out.println(fac + " " + res);
            int index = 1;
            for (int j = 1; j < n + 1; ++j) {
                if (!nums[j] && index++ == res) {
                    sb.append(j);
                    nums[j] = true;
                }
            }
            k %= fac;
        }
        for (int i = 1; i <= n; ++i) {
            if (!nums[i])
                sb.append(i);
        }
        return sb.toString();
    }

    public int factorial(int n) {
        int res = 1;
        while (n > 1) {
            res *= n--;
        }
        return res;
    }

}
