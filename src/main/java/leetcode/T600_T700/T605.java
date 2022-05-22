package leetcode.T600_T700;

public class T605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0) {
                int prev = i - 1 < 0 ? 0 : flowerbed[i - 1];
                int next = i + 1 >= flowerbed.length ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    ++count;
                    flowerbed[i] = 1;
                    if (count == n) return true;
                }
            }
        }
        return false;
    }

}
