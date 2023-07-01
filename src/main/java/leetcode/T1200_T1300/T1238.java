package leetcode.T1200_T1300;

import java.util.ArrayList;
import java.util.List;

public class T1238 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }

}
