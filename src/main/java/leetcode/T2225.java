package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class T2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        Set<Integer> players = new TreeSet<>();
        for (int[] match : matches) {
            players.add(match[0]);
            players.add(match[1]);
            losses.put(match[1], losses.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (Integer player : players) {
            Integer lossCount = losses.get(player);
            if (lossCount == null) {
                noLoss.add(player);
            }else if(lossCount==1){
                oneLoss.add(player);
            }
        }
        List<List<Integer>> res = new ArrayList<>(2);
        res.add(noLoss);
        res.add(oneLoss);
        return res;
    }

}
