import sun.jvm.hotspot.ui.action.ShowAction;

import java.util.Scanner;

public class Tencent4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] colors = new int[m + 1];
        int[] shots = new int[n];
        for (int i = 0; i < n; ++i) shots[i] = scanner.nextInt();

        int left = 0;
        int count = 0, min = n + 1;
        for (int right = 0; right < n; ++right) {
            if (shots[right] != 0) {
                colors[shots[right]]++;
                if (colors[shots[right]] == 1) ++count;
                while (count == m) {
                    min = Math.min(min, right - left + 1);
                    if (colors[shots[left]] != 0) {
                        colors[shots[left]]--;
                        if (colors[shots[left]] == 0) --count;
                    }
                    ++left;
                }
            }
        }
        if (min != n + 1)
            System.out.println(min);
        else
            System.out.println(-1);
    }

}
