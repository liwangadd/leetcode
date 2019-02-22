package leetcode.T100_T200;

import java.util.HashMap;
import java.util.Map;

public class T166 {

    public String fractionToDecimal(int numerator1, int denominator1) {
        if (numerator1 == 0) return "0";
        boolean isNegative = (numerator1 > 0 ^ denominator1 > 0);
        StringBuilder sb = new StringBuilder();
        long numerator = Math.abs((long) numerator1);
        long denominator = Math.abs((long) denominator1);
        sb.append(isNegative ? "-" : "").append(numerator / denominator);
        if (numerator % denominator == 0) return sb.toString();

        numerator %= denominator;
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(numerator)) {
            map.put(numerator, sb.length());
            numerator *= 10;
            long res = numerator / denominator;
            numerator %= denominator;
            sb.append(res);
            if (numerator == 0) return sb.toString();
        }
        sb.insert(map.get(numerator), "(");
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        T166 solution = new T166();
        System.out.println(solution.fractionToDecimal(1, -2147483648));
        System.out.println(solution.fractionToDecimal(1, 333));
        System.out.println(solution.fractionToDecimal(-55, -7));
    }

}
