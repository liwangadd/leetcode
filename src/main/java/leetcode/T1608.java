package leetcode;

public class T1608 {

    public int specialArray(int[] nums) {
        int[] counter = new int[1001];
        int len = nums.length, cur = 0;
        for (int num : nums) {
            ++counter[num];
        }
        for (int i = 0; i < counter.length; i++) {
            if (len - cur == i)
                return i;
            cur += counter[i];
        }
        return -1;
    }

}
