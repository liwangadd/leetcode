package T400_T500;

public class T414 {

    public static int thirdMax(int[] nums) {
        int max = nums[0];
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == max || nums[i] == secondMax) continue;
            if (nums[i] > max) {
                long tmp = secondMax;
                if (max > secondMax) {
                    secondMax = max;
                    if (tmp > thirdMax) {
                        thirdMax = tmp;
                    }
                }
                max = nums[i];
            } else if (nums[i] > secondMax) {
                if (secondMax > thirdMax) {
                    thirdMax = secondMax;
                }
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax != Long.MIN_VALUE) {
            return (int) thirdMax;
        } else {
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2, 2}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }

}
