package leetcode.T1000_T1100;

public class T1071 {

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) return gcdOfStrings(str2, str1);
        int endIndex = str2.length();
        while (true) {
            String gcd = str2.substring(0, endIndex);
            if (isGcd(str1, gcd) && isGcd(str2, gcd)) return gcd;
            if (--endIndex == 0) break;
            while (str2.length() % endIndex != 0) {
                --endIndex;
            }
        }
        return "";
    }

    private boolean isGcd(String str, String gcd) {
        int startIndex = 0;
        while (startIndex < str.length()) {
            if (!str.startsWith(gcd, startIndex)) return false;
            else startIndex += gcd.length();
        }
        return true;
    }

}
