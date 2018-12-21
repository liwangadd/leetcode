package leetcode.T1_T100;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class T27 {

    public int removeElement(int[] nums, int val) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[s++] = nums[i];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Caffeine.newBuilder().maximumSize(10000)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build();
    }

}
