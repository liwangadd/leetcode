package T100_T200;

public class T132 {

    public int minCut(String s) {
        if (s.length() == 0) return 0;
        int[] cut = new int[s.length()];
        cut[0] = 0;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); ++i) {
            cut[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    if (j == 0)
                        cut[i] = 0;
                    else
                        cut[i] = Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }
        return cut[s.length() - 1];
    }

}
