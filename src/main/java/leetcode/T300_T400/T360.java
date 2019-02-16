package leetcode.T300_T400;

public class T360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = a < 0 ? 0 : nums.length - 1;
        while (left <= right) {
            int val1 = compute(a, b, c, nums[left]);
            int val2 = compute(a, b, c, nums[right]);
            if (a >= 0) {
                if (val1 > val2) {
                    res[index--] = val1;
                    ++left;
                } else {
                    res[index--] = val2;
                    --right;
                }
            } else {
                if (val1 < val2) {
                    res[index++] = val1;
                    ++left;
                } else {
                    res[index++] = val2;
                    --right;
                }
            }
        }
        return res;
    }

    private int compute(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        T360 solution = new T360();
        for (int item : solution.sortTransformedArray(new int[]{-4,-2,2,4}, -1, 3, 5)) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
