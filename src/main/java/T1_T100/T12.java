package T1_T100;

public class T12 {

    public T12() {
    }

    public static String intToRoman(int num) {
        String[][] table = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (num != 0) {
            sb.insert(0, table[k++][num % 10]);
            num /= 10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }

}
