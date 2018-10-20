package T100_T200;

import java.util.Arrays;

public class T179 {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "0";
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        if (strNums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String strNum : strNums) {
            sb.append(strNum);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        T179 solution = new T179();
        System.out.println(solution.largestNumber(new int[]{10, 2}));
    }

}
