import java.util.Scanner;

public class Tencent3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; ++i) cards[i] = scanner.nextInt();
        int endPos = n - s, sCopy = s;
        int res = 1;
        for (; n > endPos; --n) {
            res *= n;
            if (s > 1 && res % sCopy == 0) {
                res /= sCopy;
                --sCopy;
            }
            res %= 1e9 + 7;
        }
        for (int i = 0; i < endPos; ++i) {
            res *= 2;
            res %= 1e9 + 7;
        }
        System.out.println(res);
    }

}
