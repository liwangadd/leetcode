public class T258 {

    public static int addDigits(int num) {
        int res, result = 0;
        while (num > 9) {
            res = num;
            result=0;
            while (res != 0) {
                result = result + res % 10;
                res /= 10;
            }
            num = result;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

}
