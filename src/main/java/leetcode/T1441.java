package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T1441 {

    public List<String> buildArray(int[] target, int n) {
        int targetIndex = 0, index = 1;
        List<String> res = new ArrayList<>();
        while (targetIndex < target.length && index <= n) {
            if (target[targetIndex] == index) {
                ++targetIndex;
                res.add("Push");
            } else if (target[targetIndex] > index) {
                res.add("Push");
                res.add("Pop");
            } else {
                break;
            }
            ++index;
        }
        if (targetIndex == target.length) return res;
        else return Collections.emptyList();
    }

}
