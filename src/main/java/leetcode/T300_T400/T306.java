package leetcode.T300_T400;

public class T306 {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        for (int i = 1; i < num.length(); ++i) {
            if (i > 1 && num.charAt(0) == '0') return false;
            for (int j = i + 1; j - i <= num.length() - j && i <= num.length() - j; ++j) {
                if (j - i > 1 && num.charAt(i) == '0')
                    continue;
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int firstEnd, int secondEnd, String num) {
        long x1 = Long.parseLong(num.substring(0, firstEnd));
        long x2 = Long.parseLong(num.substring(firstEnd, secondEnd));
        while (secondEnd < num.length()) {
            String x3 = String.valueOf(x1 + x2);
            if (num.startsWith(x3, secondEnd)) {
                x2 = x1 + x2;
                x1 = x2 - x1;
                secondEnd += x3.length();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T306 solution = new T306();
        System.out.println(solution.isAdditiveNumber("112358"));
        System.out.println();
        System.out.println(solution.isAdditiveNumber("198019823962"));
    }

}
