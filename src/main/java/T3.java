public class T3 {

    public static int lengthOfLongestSubstring(String s){
        int[] map = new int[256];

        int j = 0;
        int i = 0;
        int ans = 0;
        for (; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
