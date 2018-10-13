package T1_T100;

public class T14 {

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) minLength = str.length();
        }
        int i = 0;
        for (; i < minLength; ++i) {
            char flag = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != flag) {
                    return strs[0].substring(0, i);
                }
            }
        }
        if (i == minLength) return strs[0].substring(0, i);
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"123", "123"}));
    }

}
