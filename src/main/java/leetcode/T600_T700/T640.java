package leetcode.T600_T700;

public class T640 {

    public String solveEquation(String equation) {
        if (equation == null || equation.length() < 3 || !equation.contains("=")) return "No solution";
        int[] leftParts = new int[2], rightParts = new int[2];
        boolean isLeft = true, positive = true;
        int index = 0;
        while (index < equation.length()) {
            if (Character.isDigit(equation.charAt(index))) {
                int num = 0;
                while (index < equation.length() && Character.isDigit(equation.charAt(index))) {
                    num = num * 10 + equation.charAt(index++) - '0';
                }
                if (index < equation.length() && equation.charAt(index) == 'x') {
                    if (isLeft) leftParts[1] += positive ? num : -num;
                    else rightParts[1] += positive ? num : -num;
                    ++index;
                } else {
                    if (isLeft) leftParts[0] += positive ? num : -num;
                    else rightParts[0] += positive ? num : -num;
                }
            } else if (equation.charAt(index) == '=') {
                isLeft = false;
                positive = true;
                ++index;
            } else if (equation.charAt(index) == '-') {
                positive = false;
                ++index;
            } else if (equation.charAt(index) == '+') {
                positive = true;
                ++index;
            } else if (equation.charAt(index) == 'x') {
                if (isLeft) leftParts[1] += positive ? 1 : -1;
                else rightParts[1] += positive ? 1 : -1;
                ++index;
            }
        }
        if (leftParts[1] == rightParts[1] && leftParts[0] == rightParts[0]) return "Infinite solutions";
        if (leftParts[1] == rightParts[1]) return "No solution";
        if (rightParts[1] != 0) {
            leftParts[1] -= rightParts[1];
            rightParts[1] = 0;
        }
        if (leftParts[0] != 0) {
            rightParts[0] -= leftParts[0];
            leftParts[0] = 0;
        }
        return "x=" + (rightParts[0] / leftParts[1]);
    }

    public static void main(String[] args) {
        String res = new T640().solveEquation("2x=x");
        System.out.println(res);
    }
}
