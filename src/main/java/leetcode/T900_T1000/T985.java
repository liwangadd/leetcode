package leetcode.T900_T1000;

public class T985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0, index = 0;
        int[] res = new int[queries.length];
        for (int num : nums) {
            if ((num & 1) == 0) sum += num;
        }
        for (int[] query : queries) {
            if ((nums[query[1]] & 1) == 0)
                sum -= nums[query[1]];
            nums[query[1]] += query[0];
            if ((nums[query[1]] & 1) == 0)
                sum += nums[query[1]];
            res[index++] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        new T985().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
                {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        });
    }

}
