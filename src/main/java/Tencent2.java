import java.util.Scanner;

public class Tencent2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- != 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if ((l & 1) == 1) {
                if ((r & 1) == 1) System.out.println((r - l) / 2 - r);
                else System.out.println((r - l + 1) / 2);
            } else {
                if ((r & 1) == 1) System.out.println(-(r - l + 1) / 2);
                else System.out.println(-(r - l) / 2 + r);
            }
        }
    }
}
