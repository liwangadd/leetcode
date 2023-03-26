package leetcode.T800_T900;

public class T875 {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + ((high - low) >>> 1);
            if (canEat(piles, mid, h)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private boolean canEat(int[] piles, int target, int h) {
        int count = 0;
        for (int pile : piles) {
            count += pile / target;
            if (pile % target != 0) ++count;
        }
        return count <= h;
    }

}
