package T300_T400;

public class T342 {

    public boolean isPowerOfFour(int num) {
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

}
