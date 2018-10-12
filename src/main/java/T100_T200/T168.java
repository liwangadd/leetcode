package T100_T200;

public class T168 {

    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.append((char) ('A' + (--n) % 26));
            n /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(3));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(702));
    }

}
