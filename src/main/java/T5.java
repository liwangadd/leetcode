public class T5 {


    static String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int minLeftIndex = 0, maxRightIndex = 0, maxLength = -1;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int leftIndex = i, rightIndex = i + 1;
                while (leftIndex - 1 > -1 && rightIndex + 1 < s.length()) {
                    if (s.charAt(leftIndex - 1) == s.charAt(rightIndex + 1)) {
                        leftIndex -= 1;
                        rightIndex += 1;
                    } else {
                        break;
                    }
                }
                if (rightIndex - leftIndex + 1 > maxLength) {
                    maxLength = rightIndex - leftIndex + 1;
                    minLeftIndex = leftIndex;
                    maxRightIndex = rightIndex;
                }
            }
            int leftIndex = i, rightIndex = i;
            while (leftIndex - 1 > -1 && rightIndex + 1 < s.length()) {
                if (s.charAt(leftIndex - 1) == s.charAt(rightIndex + 1)) {
                    leftIndex -= 1;
                    rightIndex += 1;
                } else {
                    break;
                }
            }
            if (rightIndex - leftIndex + 1 > maxLength) {
                maxLength = rightIndex - leftIndex + 1;
                minLeftIndex = leftIndex;
                maxRightIndex = rightIndex;
            }
        }
        return s.substring(minLeftIndex, maxRightIndex + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

}
