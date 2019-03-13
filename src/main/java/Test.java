public class Test {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt(), count = sc.nextInt();
        int n = 5, m = 5, count = 2;
//        String[] matrix = new String[n];
        String[] matrix = {"11100", "11110", "01100", "11110", "01111"};
//        for (int i = 0; i < n; ++i) {
//            matrix[i] = sc.nextLine();
//        }
        if (n < 3 || m < 3) {
            System.out.println("0");
            return;
        }
        int res = 0, lastRow = 0;
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 0; j < m; ++j) {
                int sumCount = 0;
                for (int k = j; k < m; ++k) {
                    if (matrix[i].charAt(k) == '1' && matrix[i - 1].charAt(k) == '1' && matrix[i + 1].charAt(k) == '1') {
                        if (k - j > 0 && matrix[i].charAt(k - 1) == '1' && k < m - 1 && matrix[i].charAt(k + 1) == '1')
                            ++sumCount;
                        if (sumCount >= count) {
                            res += (m - 1 - k) * ((n - 1 - i) + (i - lastRow - 1));
                            lastRow = i;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

}