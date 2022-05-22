package leetcode.T600_T700;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class T638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs == null || needs.size() == 0) return 0;
        return helper(price, special, needs, 0);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int min = directBuy(price, needs);
        if (pos == special.size()) return min;
        int count = 0;
        while (true) {
            List<Integer> newNeeds = new LinkedList<>();
            int index = 0;
            for (; index < needs.size(); ++index) {
                if (special.get(pos).get(index) * count <= needs.get(index)) {
                    newNeeds.add(needs.get(index) - count * special.get(pos).get(index));
                } else {
                    break;
                }
            }
            if (index == needs.size()) {
                min = Math.min(min, count * special.get(pos).get(needs.size()) + helper(price, special, newNeeds, pos + 1));
            } else {
                break;
            }
            ++count;
        }
        return min;
    }

    private int directBuy(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new T638().shoppingOffers(
                Lists.newArrayList(2,3,4),
                Lists.newArrayList(Lists.newArrayList(1,1,0,4), Lists.newArrayList(2,2,1,9)),
                Lists.newArrayList(1, 2, 1)
        );
        System.out.println(res);
    }

}
