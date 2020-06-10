package leetcode.T500_T600;

import javax.xml.transform.Source;

public class T504 {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        int base = 1;
        while (base * 7 <= num) {
            base *= 7;
        }
        while (base != 0) {
            int val = num / base;
            sb.append(val);
            num = num - val * base;
            base /= 7;
        }
        if (neg) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T504 solution = new T504();
        System.out.println(solution.convertToBase7(100));
    }

}
