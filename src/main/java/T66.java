public class T66 {

    private static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int flag = 1;
        while (index > -1) {
            int tmp = digits[index] + flag;
            digits[index] = tmp % 10;
            flag = tmp / 10;
            if (flag == 0) break;
            --index;
        }
        if (flag == 1) {
            int res[] = new int[digits.length + 1];
            res[0] = flag;
            if (digits.length - 1 >= 0) System.arraycopy(digits, 1, res, 1, digits.length - 1);
            return res;
        } else {
            return digits;
        }
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
