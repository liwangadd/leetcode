package leetcode.T700_T800;

public class T779 {

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if ((k & 1) == 0) {
            return 1 ^ kthGrammar(n - 1, k / 2);
        } else {
            return kthGrammar(n - 1, (k + 1) / 2);
        }
    }

}
