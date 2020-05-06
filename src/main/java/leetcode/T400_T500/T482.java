package leetcode.T400_T500;

public class T482 {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = S.length() - 1; i > -1; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (cnt > 0 && cnt % K == 0) {
                    sb.append('-');
                }
                cnt++;
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.reverse().toString();
    }

}
