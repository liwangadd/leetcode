import java.util.Scanner;

public class Tencent1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int count = 1;
        while (m != 0) {
            count += m / n;
            m %= n;
        }
        System.out.println(count);
    }

}
