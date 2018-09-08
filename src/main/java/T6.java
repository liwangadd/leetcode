public class T6 {

    private static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            int step1 = i, step2 = numRows - i - 1;
            sb.append(s.charAt(i));
            for (int j = i; j < s.length(); ) {
                if (step2 != 0) {
                    j += step2 * 2;
                    if (j >= s.length()) break;
                    sb.append(s.charAt(j));
                }
                if (step1 != 0) {
                    j += step1 * 2;
                    if (j >= s.length()) break;
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

}
