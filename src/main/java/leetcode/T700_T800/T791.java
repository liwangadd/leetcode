package leetcode.T700_T800;

public class T791 {

    public String customSortString(String order, String s) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) {
            ++nums[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray())
            while (nums[c - 'a']-- > 0)
                sb.append(c);
        for (int i = 0; i < 26; i++) {
            while (nums[i]-- > 0) {
                char c = (char) (i + 'a');
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
