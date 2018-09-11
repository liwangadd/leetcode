import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if (a % b == 0) {
            System.out.println(a / b);
        } else if (!isLoop(a, b)) {
            System.out.println(a * 1.0 / b);
        } else {
            String str = circleDigits(a, b);
            System.out.println(str);
        }
    }

    private static boolean isLoop(int a, int b) {
        int commonDivisor = greatestCommonDivisor(a, b);
        b = b / commonDivisor;
        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }
        if (b == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int greatestCommonDivisor(int a, int b) {
        int c = 0;
        while (true) {// 循环的辗转相除法
            c = a % b;
            a = b;
            b = c;
            if (b == 0) {
                return a;
            }
        }
    }

    public static String circleDigits(int dividend, int divisor) {
        List<Integer> quotientList = new ArrayList<Integer>();//store a/b
        List<Integer> leftList = new ArrayList<Integer>();//store a%b
        int left = dividend % divisor;
        while (!leftList.contains(left)) {
            leftList.add(left);
            left *= 10;
            int quotient = left / divisor;
            quotientList.add(quotient);
            left %= divisor;
            if (left == 0) {
                return null;
            }
        }
        int circleBegin = leftList.indexOf(left);
        StringBuilder sb = new StringBuilder();
        sb.append(dividend / divisor + ".");
        if (circleBegin != 0) {
            for (int i = 0; i < circleBegin; ++i) {
                sb.append(quotientList.get(i));
            }
        }
        quotientList = quotientList.subList(circleBegin, quotientList.size());
        sb.append("(");
        for (int i = 0, len = quotientList.size(); i < len; i++) {
            sb.append(quotientList.get(i));
        }
        sb.append(")");
        return sb.toString();
    }
}