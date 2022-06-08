package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1352 {

    private List<Integer> pre;

    public T1352() {
        pre = new ArrayList<>();
        pre.add(1);
    }

    public void add(int num) {
        if (num > 0) pre.add(pre.get(pre.size() - 1) * num);
        else {
            pre = new ArrayList<>();
            pre.add(1);
        }
    }

    public int getProduct(int k) {
        return k >= pre.size() ? 0 : pre.get(pre.size() - 1) / pre.get(pre.size() - k - 1);
    }

}
