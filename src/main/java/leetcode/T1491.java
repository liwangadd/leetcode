package leetcode;

public class T1491 {

    public double average(int[] salary) {
        int max = salary[0], min = salary[0];
        for (int num : salary) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int sum = -max - min;
        for (int num : salary) {
            sum += num;
        }
        return sum * 1.0 / (salary.length - 2);
    }

}
