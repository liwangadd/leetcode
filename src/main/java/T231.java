public class T231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int flag = 1;
        for (int i = 0; i <= 32; ++i) {
            if (flag << i == n) {
                return true;
            }
        }
        return false;
    }

}
