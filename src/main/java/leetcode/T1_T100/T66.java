package leetcode.T1_T100;

public class T66 {

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        for (int i : plusOne(new int[]{1, 2, 3})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : plusOne(new int[]{9, 9, 9})) {
            System.out.print(i);
        }
    }

}
