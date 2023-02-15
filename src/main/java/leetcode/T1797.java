package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class T1797 {

    private int timeToLive;

    private TreeMap<Integer, Set<String>> time2Tokens;

    private Map<String, Integer> token2Time;

    public T1797(int timeToLive) {
        this.timeToLive = timeToLive;
        this.time2Tokens = new TreeMap<>();
        this.token2Time = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        if (token2Time.containsKey(tokenId)) {
            time2Tokens.get(token2Time.get(tokenId)).remove(tokenId);
        }
        int expiredTime = currentTime + timeToLive;
        token2Time.put(tokenId, expiredTime);
        Set<String> tokens = time2Tokens.computeIfAbsent(expiredTime, k -> new HashSet<>());
        tokens.add(tokenId);

    }

    public void renew(String tokenId, int currentTime) {
        if (!token2Time.containsKey(tokenId)) return;
        Integer expiredTime = token2Time.get(tokenId);
        if (currentTime >= expiredTime) return;
        time2Tokens.get(expiredTime).remove(tokenId);
        expiredTime = currentTime + timeToLive;
        token2Time.put(tokenId, expiredTime);
        Set<String> tokens = time2Tokens.computeIfAbsent(expiredTime, k -> new HashSet<>());
        tokens.add(tokenId);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Set<String> tokens : time2Tokens.tailMap(currentTime, false).values()) {
            count += tokens.size();
        }
        return count;
    }

}
