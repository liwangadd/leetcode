package leetcode.T500_T600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)));
        return !hs.contains(0) && hs.size()==2; //One each for side & diagonal
    }
    int dis(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }

}
