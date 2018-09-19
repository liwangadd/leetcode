public class T374 {

    public int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        if (n == 1) return 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res > 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

}
